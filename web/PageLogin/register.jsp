<%-- 
    Document   : Register
    Created on : 6 thg 3, 2024, 15:22:34
    Author     : sonhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${user}" var="user"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="register" method="post">
            <c:if test="${empty user}">
                ID: <input type="text" name="id"><br>
                FullName: <input type="text" name="fullname"><br>
                Date Of Birth:  <input type="date" name="dob" ><br>
                Gender:  <input type="radio" id="male" name="sex" value="true">
                <label for="male">Male</label>
                <input type="radio" id="female" name="sex" value="false">
                <label for="female">Female</label><br>
                Phone:<input type="text" name="phone"><br>
                Email: <input type="email" name="email"><br>
                User:     <input type="text" name="user" required><br/>
                Password: <input type="password" name="pass" required value=""><br/>
            </c:if>
            <c:if test="${not empty user}">
                ID: <input type="text" name="id"><br>
                FullName: <input type="text" name="fullname" value="${user.name}"><br>
                Date Of Birth:  <input type="date" name="dob" ><br>
                Gender:  <input type="radio" id="male" name="sex" value="true">
                <label for="male">Male</label>
                <input type="radio" id="female" name="sex" value="false">
                <label for="female">Female</label><br>
                Phone:<input type="text" name="phone"><br>
                Email: <input type="email" name="email" value="${user.email}" readonly><br>
                <input type="hidden" name="user" required value="${user.email}">
                Password: <input type="password" name="pass" required value=""><br/>
            </c:if>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
