<%-- 
    Document   : addroom
    Created on : Feb 27, 2024, 9:56:06 PM
    Author     : Dai Nhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${booking}" var="booking"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Booking</title>
        <style>
            .user-container {
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <h2>Add Booking</h2>
        <form action="checkin" method="post">
            <label for="datein">Date In:</label>
            <input type="date" id="datein" name="datein" required value="${booking.dateIn}"><br>
            <label for="dateout">Date Out:</label>
            <input type="date" id="dateout" name="dateout" required value="${booking.dateOut}"><br>
            <label for="deposit">Deposit:</label>
            <select id="deposit" name="deposite">
                <option value="0">None</option>
                <option value="5000000" <c:if test="${booking.deposite == '5000000'}">selected</c:if>>5 million</option>
                <option value="10000000"  <c:if test="${booking.deposite == '10000000'}">selected</c:if>>10 million</option>
                <option value="15000000"  <c:if test="${booking.deposite == '15000000'}">selected</c:if>>15 million</option>
                </select><br>
                <!--thêm user -->
                <label for="firstname">First Name: </label><br>
                <input type="text" id="firstname" name="firstname1"><br>

                <label for="lastname">Last Name:</label><br>
                <input type="text" id="lastname" name="lastname1"><br>

                <label for="dob">Date of Birth:</label><br>
                <input type="date" id="dob" name="dob1"><br>

                <label for="sex">Sex:</label><br>
                <input type="radio" id="male" name="sex1" value="true">
                <label for="male">Male</label>
                <input type="radio" id="female" name="sex1" value="false">
                <label for="female">Female</label><br>

                <label for="phone">Phone:</label><br>
                <input type="text" id="phone" name="phone1"><br>

                <label for="id">ID:</label><br>
                <input type="text" id="id" name="id1"><br>

                <label for="searchCountry">Search Country:</label><br>
                <select name="nationality1">
                <c:forEach items="${countries}" var="country">
                    <option value="${country}" >${country}</option>
                </c:forEach>     
            </select><br>
            <c:choose>
                <c:when test="${ not empty booking}">
                    <input type="hidden" name="roomnum" value="${booking.roomNumber}">
                    <input type="hidden" name="idbooking" value="${booking.id}">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="roomnum" value="${roomnum}">
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
