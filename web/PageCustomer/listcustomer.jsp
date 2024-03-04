
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="functions" uri="/WEB-INF/tlds/myFunctions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Customers</title>
        <script type="text/javascript">

            function doDelete(ID) {               
                if (confirm("Are you sure to delete " + ID)) {
                    window.location = "deletecustomer?ID=" + ID;
                }
            }
        </script>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">List of Customers</h2>
            <a href="addcustomer" class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg--600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800 mb-4">Add</a>
            <c:choose>
                <c:when test="${not empty requestScope.list}">
                    <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                        <table class="w-full text-base font-sans border-collapse">
                            <thead class="text-white text-left" style="background-color: #009879">
                                <tr>
                                    <th scope="col" class="px-6 py-3">
                                        ID
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Full Name
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Date of Birth
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Gender
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Phone
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Nationality
                                    </th>
                                    <th scope="col" class="px-6 py-3 ">
                                        Action
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="customer">
                                    <tr class="border-b">
                                        <td class="px-6 py-4">
                                            ${customer.id}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${customer.fullName}
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${customer.dob}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            ${functions:convertGender(customer.sex)}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${customer.phone}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${customer.nationality}
                                        </td>
                                        <td class="flex px-4 py-4  justify-between text-sm">
                                            <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline" onclick="doDelete(${customer.id})">Delete</a>
                                            <a href="updatecustomer?ID=${customer.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <br>
                    <p class="my-10">${requestScope.notice}</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
