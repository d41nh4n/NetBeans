<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="room" value="${room}"/>
<c:set var="customer" value="${customer}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Room Information:</h2>
        <ul>
            <li>Room Number: ${room.roomNum}</li>
            <li>Availability: ${room.available}</li>
            <li>Type ID: ${room.idType}</li>
            <li>Type Name: ${room.typeName}</li>
            <li>Price Per Month: ${room.pricePerMonth}</li>
            <li>Price Per Day: ${room.pricePerDay}</li>
                <c:if test="${not empty room.usingRoom}">
                <li>
                    Using Room Information:
                    <ul>
                        <li>Number of Users: ${room.usingRoom.numberUser}</li>
                        <li>Date In: ${room.usingRoom.datein}</li>
                        <li>Date Out: ${room.usingRoom.dateout}</li>
                        <li>Deposit: ${room.usingRoom.deposite}</li>
                        <li>Total Price: ${room.usingRoom.priceTotal}</li>
                    </ul>
                </li>
            </c:if>
        </ul>
        <c:forEach var="user" items="${user.customers}">
            <h2>Customer Information:</h2>
            <ul>
                <li>Full Name: ${user.fullName}</li>
                <li>Date of Birth: ${user.dob}</li>
                <li>Sex: ${user.sex}</li>
                <li>Phone: ${user.phone}</li>
                <li>ID: ${user.id}</li>
                <li>Nationality: ${user.nationality}</li>
                <!-- Add other customer attributes as needed -->
            </ul>
        </c:forEach>
        <c:choose>
            <c:when test="${empty room.usingRoom}">
                <a href="checkio?roomnum=${room.roomNum}&action=checkin">Check-in</a>
            </c:when>
            <c:otherwise>
                <a href="checkio?roomnum=${room.roomNum}&action=edit">Edit</a>
                <a href="checkio?roomnum=${room.roomNum}&action=checkout">Check-Out</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>
