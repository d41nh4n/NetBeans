<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Employees</title>
        <!-- Add your CSS stylesheets or styles here -->
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">List of Employees</h2>
            <!-- Add link to add new employee -->
            <a href="addemployee" class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg--600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800 mb-4">Add</a>

            <!-- Check if there are employees in the list -->
            <c:if test="${not empty requestScope.employeeList}">
                <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                    <table class="w-full text-base font-sans border-collapse">
                        <thead class="text-white text-left" style="background-color: #009879">
                            <tr>
                                <th scope="col" class="px-6 py-3">ID</th>
                                <th scope="col" class="px-6 py-3">Full Name</th>
                                <th scope="col" class="px-6 py-3">Date of Birth</th>
                                <th scope="col" class="px-6 py-3">Gender</th>
                                <th scope="col" class="px-6 py-3">Phone</th>
                                <th scope="col" class="px-6 py-3">Username</th>
                                <th scope="col" class="px-6 py-3">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iterate over the list of employees -->
                            <c:forEach items="${requestScope.employeeList}" var="employee">
                                <tr class="border-b">
                                    <td class="px-6 py-4">${employee.id}</td>
                                    <td class="px-6 py-4">${employee.fullName}</td>
                                    <td class="px-6 py-4"><fmt:formatDate pattern="MM-dd-yyyy" value="${employee.dob}" /></td>
                                    <td class="px-6 py-4">${employee.sex ? 'Male' : 'Female'}</td>
                                    <td class="px-6 py-4">${employee.phone}</td>
                                    <td class="px-6 py-4">${employee.userName}</td>
                                    <td class="flex px-4 py-4 justify-between text-sm">
                                        <!-- Link to delete employee -->
                                        <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline" onclick="doDelete(${employee.id})">Delete</a>
                                        <a href="updateemployee?ID=${employee.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <!-- Display a notice if there are no employees -->
            <c:if test="${empty requestScope.employeeList}">
                <br>
                <p class="my-10">${requestScope.notice}</p>
            </c:if>
        </div>
    </body>
</html>
