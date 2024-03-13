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
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex items-center justify-center h-screen">
        <div class="bg-white rounded-lg shadow-md p-8 max-w-md w-full">
            <h1 class="text-3xl font-bold mb-4">Login</h1>

            <c:if test="${not empty notice}">
                <div class="mb-4 bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded" role="alert">
                    <p>${notice}</p>
                </div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="mb-4 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded" role="alert">
                    <p>${error}</p>
                </div>
            </c:if>

            <form action="login" method="post" class="space-y-4">
                <div class="flex flex-col">
                    <label for="user" class="mb-1">User</label>
                    <input type="text" id="user" name="user" required class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                </div>
                <div class="flex flex-col">
                    <label for="pass" class="mb-1">Password</label>
                    <input type="password" id="pass" name="pass" required class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                </div>
                <div class="flex justify-between items-center">
                    <input type="submit" value="Submit" class="px-6 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
                    <input type="button" value="Register" onclick="window.location.href = 'register'" class="px-6 py-2 bg-green-500 text-white rounded hover:bg-green-600 cursor-pointer">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&redirect_uri=http://localhost:8080/Assignment/logingoogle&response_type=code&client_id=471002202148-7er02jdudkrf7st1eha9et0vl5bts920.apps.googleusercontent.com&approval_prompt=force" class="px-6 py-2 bg-red-500 text-white rounded hover:bg-red-600 cursor-pointer">Login With Google</a>
                </div>
            </form>
        </div>
    </body>
</html>
