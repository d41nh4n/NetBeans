<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="booking" value="${requestScope.booking}"/>
<html>
    <head>
        <title>Add Booking</title>
        <style>
            body {
                font-size: small;
            }
        </style>
        <script>
            function validateDates() {
                var dateIn = document.getElementById("dateIn").value;
                var dateOut = document.getElementById("dateOut").value;
                var today = new Date();

                if (dateIn < today) {
                    alert("Check-in date cannot be in the past.");
                    return false;
                }

                if (dateIn >= dateOut) {
                    alert("Date Out must be greater than Date In.");
                    return false;
                }

                return true;
            }
        </script>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            
            <h2>Update Booking</h2>
            <c:if test="${not empty error}">
                <h3 class="text-red-500">${error}</h3>
            </c:if>
            <form action="updatebooking" method="post"  onsubmit="return validateDates()">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" value="${booking.customerName}" required/><br/>

                <label for="roomNumber">Room Number:</label>
                <input type="text" id="roomNumber" name="roomNumber" value="${booking.roomNumber}" required/><br/>

                <label for="dateIn">Date In:</label>
                <input type="date" id="dateIn" name="dateIn" value="${booking.dateIn}" required/><br/>

                <label for="dateOut">Date Out:</label>
                <input type="date" id="dateOut" name="dateOut" value="${booking.dateOut}" required/><br/>

                <label for="deposite">Deposite: </label>
                <select id="deposite" name="deposite">
                    <option value="0">None</option>
                    <option value="5000000" <c:if test="${booking.deposite == '5000000'}">selected</c:if>>5 million</option>
                    <option value="10000000"  <c:if test="${booking.deposite == '10000000'}">selected</c:if>>10 million</option>
                    <option value="15000000"  <c:if test="${booking.deposite == '15000000'}">selected</c:if>>15 million</option>
                    </select><br>

                    <label for="contact">Contact:</label>
                    <input type="text" id="contact" name="contact" required value="${booking.contact}"/><br/>
                <input type="hidden" id="Id" name="Id" value="${booking.id}"/><br/>
                <input type="hidden" id="dateExec" name="dateExec" value="${booking.execDate}"/>
                <input type="submit" name="submit" value="Update"/>
            </form>
                </div>
    </body>
</html>
