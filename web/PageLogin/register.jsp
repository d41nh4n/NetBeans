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
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <style>
            /* Định dạng phần form */
            .form-section {
                max-width: 500px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #fff;
            }

            /* Định dạng tiêu đề */
            h1 {
                font-size: 24px;
                margin-bottom: 20px;
                text-align: center;
            }

            /* Định dạng các input và label */
            input[type="text"],
            input[type="email"],
            input[type="date"],
            input[type="password"],
            input[type="radio"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Định dạng nút Submit */
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            /* Định dạng các label */
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            /* Định dạng định dạng của radio buttons và label */
            input[type="radio"] {
                margin-right: 5px;
                transform: scale(1.2);
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="form-section">
            <h1>Register</h1>
            <form action="register" method="post">
                <c:if test="${empty user}">
                    <label for="id">ID:</label>
                    <input type="text" name="id" id="id">
                    <label for="fullname">FullName:</label>
                    <input type="text" name="fullname" id="fullname">
                    <label for="dob">Date Of Birth:</label>
                    <input type="date" name="dob" id="dob">
                    <label>Gender:</label>
                    <div class="flex items-center space-x-4">
                        <label for="male" class="inline-flex items-center">
                            <input type="radio" id="male" name="sex" value="true" class="form-radio">
                            <span class="ml-2">Male</span>
                        </label>
                        <label for="female" class="inline-flex items-center">
                            <input type="radio" id="female" name="sex" value="false" class="form-radio">
                            <span class="ml-2">Female</span>
                        </label>
                    </div>
                    <label for="phone">Phone:</label>
                    <input type="text" name="phone" id="phone">
                    <label for="email">Email:</label>
                    <input type="email" name="email" id="email">
                    <label for="user">User:</label>
                    <input type="text" name="user" id="user" required>
                    <label for="pass">Password:</label>
                    <input type="password" name="pass" id="pass" required>
                </c:if>
                <c:if test="${not empty user}">
                    <label for="id">ID:</label>
                    <input type="text" name="id" id="id">
                    <label for="fullname">FullName:</label>
                    <input type="text" name="fullname" id="fullname" value="${user.name}">
                    <label for="dob">Date Of Birth:</label>
                    <input type="date" name="dob" id="dob">
                    <label>Gender:</label>
                    <div class="flex items-center space-x-4">
                        <label for="male" class="inline-flex items-center">
                            <input type="radio" id="male" name="sex" value="true" class="form-radio">
                            <span class="ml-2">Male</span>
                        </label>
                        <label for="female" class="inline-flex items-center">
                            <input type="radio" id="female" name="sex" value="false" class="form-radio">
                            <span class="ml-2">Female</span>
                        </label>
                    </div>
                    <label for="phone">Phone:</label>
                    <input type="text" name="phone" id="phone">
                    <label for="email">Email:</label>
                    <input type="email" name="email" id="email" value="${user.email}" readonly>
                    <input type="hidden" name="user" id="user" value="${user.email}" required>
                    <label for="pass">Password:</label>
                    <input type="password" name="pass" id="pass" required>
                </c:if>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>

</html>
