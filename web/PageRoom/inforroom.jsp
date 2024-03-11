<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="functions" uri="/WEB-INF/tlds/myFunctions" %>
<c:set var="room" value="${room}"/>
<c:set var="user" value="${user}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script>
            function openModelDeposit() {
                document.getElementById('Deposit').classList.remove('hidden');
            }

            function closeModelDeposit() {
                document.getElementById('Deposit').classList.add('hidden');
            }
        </script>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <h2 class="text-3xl my-10 flex justify-center">Room Information</h2>
        <div class="grid grid-cols-3 gap-3 mx-16 text-lg">
            <div class="">
                <ul>
                    <li class="font-bold">Room Number: ${room.roomNum}</li>
                    <li class="font-bold">Availability: ${room.available}</li>
                    <li class="font-bold">Type Name: ${room.typeName}</li>
                    <li class="font-bold">Price Per Month: ${room.pricePerMonth}</li>
                    <li class="font-bold">Price Per Day: ${room.pricePerDay}</li>
                    <li class="font-bold">Status Using:</li>
                        <c:if test="${not empty room.usingRoom}">
                        <li>
                            Using Room Information:
                            <ul>
                                <li>Number of Users: ${room.usingRoom.numberUser}</li>
                                <li>Date In: ${room.usingRoom.datein}</li>
                                <li>Date Out: ${room.usingRoom.dateout}</li>
                                <li>Deposit: ${room.usingRoom.deposite}</li>
                                <li>Total Price: ${room.usingRoom.priceTotal}</li>
                            </ul>
                        </li>
                    </c:if>
            </div>
            <div class="h-35rem max-w-full flex justify-center">
                <img src="data:image/jpeg;base64,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" alt="alt"/>
            </div>
            <div class="col-start-3"> 
                <c:choose>
                    <c:when test="${empty room.usingRoom}">
                        <a href="checkio?roomnum=${room.roomNum}&action=checkin" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Check-in</a>
                    </c:when>
                    <c:otherwise>
                        <a href="checkio?roomnum=${room.roomNum}&action=edit" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Edit</a>
                        <a href="checkio?roomnum=${room.roomNum}&action=checkout" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Check-Out</a>
                        <c:if test="${status == 'month'}">
                            <button type="button" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onclick="openModelDeposit()">Deposit</button>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
        </ul>

        <div class="col-start-2">
            <div class="my-8 w-100%"> <!-- Thêm class w-4/5 vào đây -->
                <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">Customer Information</h2>
                <c:if test="${not empty user}">
                    <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                        <table class="w-full text-sm font-sans border-collapse">
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
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${user.customers}">
                                    <tr class="border-b">
                                        <td class="px-6 py-4">
                                            ${user.id}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${user.fullName}
                                        </td>
                                        <td class="px-6 py-4">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${user.dob}" />
                                        </td>
                                        <td class="px-6 py-4">
                                            ${functions:convertGender(user.sex)}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${user.phone}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${user.nationality}
                                        </td>
                                    </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="col-start-2">

            <c:if test="${not empty list}">
                <h2>History Pay</h2>
                <h3>Total Price: </h3>
                <span class="text-sky-400">0</span>/${room.usingRoom.priceTotal}
                <table class="w-full text-sm font-sans border-collapse">
                    <thead class="text-white text-left" style="background-color: #009879">
                        <tr>
                            <th scope="col" class="px-3 py-4">
                                Date
                            </th>
                            <th scope="col" class="px-6 py-4">
                                Money
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="his">
                        <td class="px-3 py-4">
                            <fmt:formatDate pattern="MM-dd-yyyy" value="${his.dateIn}" />
                        </td>
                        <td class="px-6 py-4">
                            <fmt:formatNumber value="${his.totalMoney}" type="number" pattern="#,##0" />  
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div> 
    </div>
</body>
<!-- model deposit -->
<div>
    <div id="Deposit" class="fixed inset-0 z-50 overflow-auto bg-gray-800 bg-opacity-50 flex justify-center items-center hidden">
        <div class="bg-white w-1/2 p-8 rounded-lg">
            <div class="flex justify-between">
                <h2 class="text-lg font-bold">Pay Rent</h2>
                <button class="text-gray-500 hover:text-gray-700" onclick="closeModelDeposit()">&times;</button>
            </div>
            <form action="insertrm" method="post"> 
                <h2>Amount money ${room.roomNum} have to pay for next month is:</h2> 
                <input type="number" value="${room.pricePerMonth}" name="money"><br>
                <input type="hidden" value="${room.roomNum}" name="roomnum"><br>
                <input type="hidden" value="${sessionScope.manager.userName}" name="manager"><br>
                <button type="submit" >Pay by cash</button>
            </form>
            </select><br>
            </form>
        </div>
    </div>
</div>
</html>
