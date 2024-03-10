<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Accounts</title>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">List of Accounts</h2>
            <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                <table class="w-full text-base font-sans border-collapse">
                    <thead class="text-white text-left" style="background-color: #009879">
                        <tr>
                            <th scope="col" class="px-6 py-3">User Name</th>
                            <th scope="col" class="px-6 py-3">Role</th>
                            <th scope="col" class="px-6 py-3">Status</th>
                            <th scope="col" class="px-6 py-3">Email</th>
                            <th scope="col" class="px-6 py-3">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iterate over the list of accounts -->
                        <c:forEach items="${requestScope.accountList}" var="account">
                            <tr class="border-b">
                                <td class="px-6 py-4">${account.userName}</td>
                                <td class="px-6 py-4">${account.role}</td>
                                <td class="px-6 py-4">${account.status ? 'Active' : 'Inactive'}</td>
                                <td class="px-6 py-4">${account.email}</td>
                                <td class="px-6 py-4">
                                    <button type="button" onclick="openModal()">Edit</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <div>

    </div>
</html>
