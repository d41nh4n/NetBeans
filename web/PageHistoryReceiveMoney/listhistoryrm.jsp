<%-- 
    Document   : listhistory
    Created on : Mar 7, 2024, 1:06:52 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="choice" value="${searchchoice}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-32">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">History Receive Money</h2>
            <form action="listhistoryrm" method="get">
                <select id="searchchoice" name="searchchoice">
                    <option value="id" <c:if test="${choice == 'id'}">selected</c:if>>default</option>
                    <option value="sortbyroomfromlowtohigh" <c:if test="${choice == 'sortbyroomfromlowtohigh'}">selected</c:if>>Sort by room num from low to high</option>
                    <option value="sortbyroomfromhightolow" <c:if test="${choice == 'sortbyroomfromhightolow'}">selected</c:if>>Sort by room num from high to low</option>
                    <option value="datepaynewtoold" <c:if test="${choice == 'datepaynewtoold'}">selected</c:if>>Sort by date-pay new to old</option>
                    <option value="datepayoldtonew" <c:if test="${choice == 'datepayoldtonew'}">selected</c:if>>Sort by date-pay old to new</option>
                    <option value="moneylowtohigh" <c:if test="${choice == 'moneylowtohigh'}">selected</c:if>>Sort by money from low to high</option>
                    <option value="moneyhightolow" <c:if test="${choice == 'moneyhightolow'}">selected</c:if>>Sort by money from high to low</option>
                    </select>
                    <input type="submit" value="Sort">
                </form>
            <c:choose>
                <c:when test="${not empty requestScope.list}">
                    <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                        <table class="w-full text-sm font-sans border-collapse">
                            <thead class="text-white text-left" style="background-color: #009879">
                                <tr>
                                    <th scope="col" class="px-3 py-4">
                                        ID
                                    </th>
                                    <th scope="col" class="px-6 py-4">
                                        Room Num
                                    </th>
                                    <th scope="col" class="px-8 py-4">
                                        Date Pay
                                    </th>
                                    <th scope="col" class="px-10 py-4">
                                        Money
                                    </th>
                                    <th scope="col" class="px-10 py-4">
                                        Status
                                    </th>
                                    <th scope="col" class="px-6 py-4">
                                        User Name
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="history">
                                    <tr class="border-b">
                                        <td class="px-3 py-4">
                                            ${history.id}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${history.roomNum}
                                        </td>
                                        <td class="px-8 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${history.datePay}" />
                                        </td>
                                        <td class="px-10 py-4">
                                            ${history.money}
                                        </td>
                                        <td class="px-10 py-4">
                                            ${history.status}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${history.userName}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <br>
                    <p>${requestScope.notice}</p>
                </c:otherwise>
            </c:choose>
            <div class="mx-16">
                <c:forEach begin="1" end="${numberPage}" var="i">
                    <a href="listhistoryrm?page=${i}&searchchoice=${searchchoice}" class="inline-block w-10 h-7 text-center bg-white text-gray-700 border border-gray-300 rounded-md hover:bg-gray-100 mx-0.5 my-8">${i}</a>
                </c:forEach>
            </div>
        </div>

        ${numberPage}
    </body>
</html>
