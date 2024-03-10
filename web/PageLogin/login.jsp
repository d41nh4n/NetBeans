<%-- 
    Document   : Login
    Created on : Jan 6, 2024, 10:27:47 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>

        <%           
             if(request.getAttribute("error")!=null){
            String a =(String)request.getAttribute("error");
        %>
        <h2 style="color: red"><%=a%></h2>
        <%    
            }
        %>  

        <form action="login" method="post">
            User<input type="text" name="user" required><br/>
            Password<input type="password" name="pass" required><br/>
            <input type="submit" value="Submit">
            <input type="submit" value="Register" onclick="window.location.href = 'Register.jsp'">
            <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&redirect_uri=http://localhost:8080/Assignment/logingoogle&response_type=code&client_id=471002202148-7er02jdudkrf7st1eha9et0vl5bts920.apps.googleusercontent.com&approval_prompt=force">
                Login With Google</a>
        </form>
    </body>

</html>
