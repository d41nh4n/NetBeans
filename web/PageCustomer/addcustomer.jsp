<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Input Form</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100">
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="container mx-auto mt-10 "> 
            <h1 class="text-3xl font-bold mb-4">Customer Input Form</h1>
            <div class="w-full max-w-lg bg-white rounded-lg shadow-md p-8 flex flex-grow">
                <form action="addcustomer" method="post">
                    <span style="color:red">${notice}</span>
                    <div class="mb-4">
                        <label for="firstname" class="block mb-2">First Name:</label>
                        <input type="text" id="firstname" name="firstname" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="mb-4">
                        <label for="lastname" class="block mb-2">Last Name:</label>
                        <input type="text" id="lastname" name="lastname" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="mb-4">
                        <label for="dob" class="block mb-2">Date of Birth:</label>
                        <input type="date" id="dob" name="dob" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="mb-4">
                        <label for="sex" class="block mb-2">Sex:</label>
                        <input type="radio" id="male" name="sex" value="true" class="mr-2" required><label for="male">Male</label>
                        <input type="radio" id="female" name="sex" value="false" class="ml-4 mr-2" required><label for="female">Female</label>
                    </div>
                    <div class="mb-4">
                        <label for="phone" class="block mb-2">Phone:</label>
                        <input type="text" id="phone" name="phone" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="mb-4">
                        <label for="id" class="block mb-2">ID:</label>
                        <input type="text" id="id" name="id" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="mb-4">
                        <label for="nationality" class="block mb-2">Nationality:</label>
                        <select name="nationality" required class="w-full px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                            <c:forEach items="${sessionScope.countries}" var="country">
                                <option value="${country}" class="py-1">${country}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="text-center">
                        <input type="submit" value="Submit" class="py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
