<%-- 
    Document   : Login
    Created on : Jan 6, 2024, 10:27:47 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>

        <c:if test="${ not empty notice}">
            <h2>${notice}</h2>
        </c:if>
        <c:if test="${ not empty error}">
            <h2>${error}</h2>
        </c:if>
        <form action="login" method="post">
            User<input type="text" name="user" required><br/>
            Password<input type="password" name="pass" required><br/>
            <input type="submit" value="Submit">
            <input type="submit" value="Register" onclick="window.location.href = 'register'">
            <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&redirect_uri=http://localhost:8080/Assignment/logingoogle&response_type=code&client_id=471002202148-7er02jdudkrf7st1eha9et0vl5bts920.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
        </form>
    </body>

</html>
