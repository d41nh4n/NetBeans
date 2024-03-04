<%-- 
    Document   : addcustomer
    Created on : Feb 25, 2024, 1:20:22 PM
    Author     : Dai Nhan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Input Form</title>
    </head>

    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mt-10"> 
            <h1>Customer Input Form</h1>
            <div class="">
                <form action="addcustomer" method="post">
                    <label for="firstname">First Name: </label><br>
                    <input type="text" id="firstname" name="firstname" required><br>

                    <label for="lastname">Last Name:</label><br>
                    <input type="text" id="lastname" name="lastname" required><br>

                    <label for="dob">Date of Birth:</label><br>
                    <input type="date" id="dob" name="dob" required><br>

                    <label for="sex">Sex:</label><br>
                    <input type="radio" id="male" name="sex" value="true">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="sex" value="false">
                    <label for="female">Female</label><br>

                    <label for="phone">Phone:</label><br>
                    <input type="text" id="phone" name="phone" required><br>

                    <label for="id">ID:</label><br>
                    <input type="text" id="id" name="id" required><br>

                    <label for="searchcountry">Search Country:</label><br>
                    <select name="nationality" required><br>
                        <c:forEach items="${countries}" var="country">
                            <option value="${country}" >${country}</option>
                        </c:forEach>     
                    </select> <br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>


