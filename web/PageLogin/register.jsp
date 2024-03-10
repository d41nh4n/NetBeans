<%-- 
    Document   : Register
    Created on : 6 thg 3, 2024, 15:22:34
    Author     : sonhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="RegisterServlet" method="post">
            ID: <input type="text" name="id"><br>
            FullName: <input type="text" name="fullname"><br>
            Date Of Birth:  <input type="date" name="dob"><br>
            Gender:  <input type="radio" id="male" name="sex" value="true">
            <label for="male">Male</label>
            <input type="radio" id="female" name="sex" value="false">
            <label for="female">Female</label><br>
            Phone:<input type="text" name="phone"><br>
            Email: <input type="email" name="email"><br>
            User:     <input type="text" name="user" required><br/>
            Password: <input type="password" name="pass" required><br/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
