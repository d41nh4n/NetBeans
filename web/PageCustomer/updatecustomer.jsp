<%-- 
    Document   : addcustomer
    Created on : Feb 25, 2024, 1:20:22 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="customer" value="${requestScope.customer}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Input Form</title>
        <!-- Import Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>

    <body class="bg-gray-100">
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mt-10">
            <h1 class="text-2xl font-bold mb-4 flex justify-center">Update Customer</h1>
            <div class="max-w-lg mx-auto bg-white p-6 rounded shadow">
                <form action="updatecustomer" method="post">
                       <span style="color:red">${notice}</span>
                    <div class="mb-4">
                        <label for="fullname" class="block text-gray-700">Full Name:</label>
                        <input type="text" id="fullname" name="fullname" value="${customer.fullName}" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                    </div>

                    <div class="mb-4">
                        <label for="dob" class="block text-gray-700">Date of Birth:</label>
                        <input type="date" id="dob" name="dob" value="${customer.dob}" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                    </div>

                    <div class="mb-4">
                        <label class="block text-gray-700">Sex:</label>
                        <div class="flex items-center">
                            <input type="radio" id="male" name="sex" value="true" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300" <c:if test="${customer.sex == true}">checked</c:if>>
                                <label for="male" class="ml-2 block text-sm text-gray-900">Male</label>
                                <input type="radio" id="female" name="sex" value="false" class="ml-4 focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300" <c:if test="${customer.sex == false}">checked</c:if>>
                                <label for="female" class="ml-2 block text-sm text-gray-900">Female</label>
                            </div>

                        </div>
                        <div class="mb-4">
                            <label for="phone" class="block text-gray-700">Phone:</label>
                            <input type="text" id="phone" name="phone" value="${customer.phone}" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                    </div>

                    <div class="mb-4">
                        <label for="id" class="block text-gray-700">ID:</label>
                        <input type="text" id="id" name="id" value="${customer.id}" readonly class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                    </div>

                    <div class="mb-4">
                        <label for="nationality" class="block text-gray-700">Search Country:</label>
                        <select name="nationality" required class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                            <c:forEach items="${countries}" var="country">
                                <option value="${country}" <c:if test="${customer.nationality == country}">selected</c:if>>${country}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 focus:outline-none focus:bg-blue-600">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
