<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>List of Bookings</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.tailwindcss.com"></script>
        <script type="text/javascript">

            function doDelete(ID) {
                if (confirm("Are you sure to delete")) {
                    window.location = "cancelbooking?ID=" + ID;
                }
            }

            function doConfirm(ID) {
                if (confirm("Are you sure to confirm")) {
                    var start = "booking";
                    window.location = "checkio?ID=" + ID+ "&action="+ start;
                }
            }

        </script>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">List of Bookings</h2>
            <a href="addbooking" class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg--600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800 mb-4">Add</a>
            <c:choose>
                <c:when test="${not empty requestScope.list}">
                    <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                        <table class="w-full text-sm font-sans border-collapse">
                            <thead class="text-white text-left" style="background-color: #009879">
                                <tr>
                                    <th scope="col" class="px-6 py-3">
                                        Customer Name
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Room Number
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Date In
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Date Out
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Exec Date
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Exec Deposit
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Contact
                                    </th>
                                    <th scope="col" class=" flex px-6 py-3 justify-center">
                                        Action
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="booking">
                                    <tr class="border-b">
                                        <td class="px-6 py-4">
                                            ${booking.customerName}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${booking.roomNumber}
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${booking.dateIn}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${booking.dateOut}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${booking.execDate}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatNumber value="${booking.deposite}" type="number" pattern="#,##0" />
                                        </td>
                                        <td class="px-3 py-4">
                                            ${booking.contact}
                                        </td>
                                        <td class="flex px-3 py-4  justify-between text-sm">
                                            <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline" onclick="doConfirm(${booking.id})">Confirm</a>
                                            <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline" onclick="doDelete(${booking.id})">Cancle</a>
                                            <a href="updatebooking?ID=${booking.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Update</a>
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


