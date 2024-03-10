<%-- 
    Document   : addroom
    Created on : Feb 27, 2024, 9:56:06 PM
    Author     : Dai Nhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${sessionScope.users}" var="booking"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Booking</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    </head>
    <body>
        <c:forEach items="${sessionScope.manager}" var="u">
            ${u}
        </c:forEach>
    </body>
</html>
