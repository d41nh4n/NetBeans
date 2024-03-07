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
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">History</h2>
            <form action="listhistory" method="get">
                <select id="searchchoice" name="searchchoice">
                    <option value="id" <c:if test="${choice == 'id'}">selected</c:if>>default</option>
                    <option value="dateinoldtonew" <c:if test="${choice == 'dateinoldtonew'}">selected</c:if>>Sort by date-in old to new</option>
                    <option value="dateinnewtoold" <c:if test="${choice == 'dateinnewtoold'}">selected</c:if>>Sort by date-in new to old</option>
                    <option value="dateoutoldtonew" <c:if test="${choice == 'dateoutoldtonew'}">selected</c:if>>Sort by date-out old to new</option>
                    <option value="dateoutoldtonew" <c:if test="${choice == 'dateoutoldtonew'}">selected</c:if>>Sort by date-out new to old</option>
                    <option value="pricelowtohigh" <c:if test="${choice == 'pricelowtohigh'}">selected</c:if>>Sort by price from low to high</option>
                    <option value="pricehightolow" <c:if test="${choice == 'pricehightolow'}">selected</c:if>>Sort by price from high to low</option>
                    </select>
                    <input type="submit" value="Sort">
                </form>
            <c:choose>
                <c:when test="${not empty requestScope.list}">
                    <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                        <table class="w-full text-sm font-sans border-collapse">
                            <thead class="text-white text-left" style="background-color: #009879">
                                <tr>
                                    <th scope="col" class="px-3 py-3">
                                        ID
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Room Num
                                    </th>
                                    <th scope="col" class="px-3 py-3">
                                        Number User
                                    </th>
                                    <th scope="col" class="px-8 py-3">
                                        Date In
                                    </th>
                                    <th scope="col" class="px-8 py-3">
                                        Date Out
                                    </th>
                                    <th scope="col" class="px-10 py-3">
                                        TotalMoney
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="history">
                                    <tr class="border-b">
                                        <td class="px-6 py-4">
                                            ${history.id}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${history.roomNum}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${history.numberCus}
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${history.dateIn}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${history.dateIn}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            ${history.totalMoney}
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
                    <a href="listhistory?page=${i}&searchchoice=${searchchoice}" class="inline-block w-10 h-7 text-center bg-white text-gray-700 border border-gray-300 rounded-md hover:bg-gray-100 mx-0.5 my-8">${i}</a>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
