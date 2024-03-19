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
    </script>
</head>
<body>
    <header><jsp:include page="../menu.jsp"/></header>
    <h2 class="text-3xl my-10 flex justify-center">Room Information</h2>
    <div class="grid grid-cols-3 gap-3 mx-16 text-lg">
        <div class="">
            <ul>
                <li class="font-bold">Room Number: ${room.roomNum}</li>
                <li class="font-bold">Type Name: ${room.typeName}</li>
                <li class="font-bold">Price Per Day  <fmt:formatNumber value="${room.pricePerDay}" type="number" pattern="#,##0" /></li>
                <li class="font-bold">Price Per Month <fmt:formatNumber value="${room.pricePerMonth}" type="number" pattern="#,##0" /></li>
                    <c:if test="${status != null}">
                    <li class="font-bold">Status Using: ${status}</li>
                    </c:if>
                    <c:if test="${not empty room.usingRoom}">
                    <li>
                        Using Room Information:
                        <ul>
                            <li>Number of Users: ${room.usingRoom.numberUser}</li>
                            <li>Date In: ${room.usingRoom.datein}</li>
                            <li>Date Out: ${room.usingRoom.dateout}</li>
                            <li>Deposit: <fmt:formatNumber value="${room.usingRoom.deposite}" type="number" pattern="#,##0" /></li>
                            <li>Total Price: <fmt:formatNumber value="${room.usingRoom.priceTotal}" type="number" pattern="#,##0" />  </li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <div class="col-start-3 text-center"> 
            <c:choose>
                <c:when test="${empty room.usingRoom}">
                    <a href="checkio?roomnum=${room.roomNum}&action=checkin" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Check-in</a>
                </c:when>
                <c:otherwise>
                    <a href="checkio?roomnum=${room.roomNum}&action=edit" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Edit</a>
                    <a href="checkio?roomnum=${room.roomNum}&action=checkout" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Check-Out</a>
                    <button type="button" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onclick="openModelDeposit()">Deposit</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="col-start-2 mx-32">
        <c:if test="${not empty list}">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">History Pay</h2>
            <h3>Total Price: </h3>
            <span id="totalPaid" class="text-sky-400"><fmt:formatNumber value="${totalNumber}" type="number" pattern="#,##0"/></span>/<fmt:formatNumber value="${room.usingRoom.priceTotal}" type="number" pattern="#,##0" />  
            <table class="w-full text-sm font-sans border-collapse text-center shadow-md rounded mt-4">
                <thead class="text-white" style="background-color: #009879">
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
                        <fmt:formatDate pattern="MM-dd-yyyy" value="${his.datePay}" />
                    </td>
                    <td class="px-6 py-4">
                        <fmt:formatNumber value="${his.money}" type="number" pattern="#,##0" />  
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div> 
</div>


<div class="bg-white h-10 mt-10">
    <!-- Đây là footer -->
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
            <h2>Amount money ${room.roomNum} have to pay for next month is: <fmt:formatNumber value="${room.pricePerMonth}" type="number" pattern="#,##0" />  </h2> 
            <form action="insertrm" method="post"onsubmit="return validateForm()"> 
                <input id="action" type="hidden" value="paypal" name="action" readonly>
                <input id="status" type="hidden" value=" ${status}" name="status" readonly>
                <input id="totalPayed" type="hidden" value="${totalNumber}" name="totalPayed" readonly>
                <input type="hidden" value="${room.roomNum}" name="roomnum" readonly>
                <input type="hidden" value="${sessionScope.manager.userName}" name="manager" readonly>
                <button type="submit" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4">Pay by PayPal</button>
            </form>
            <form action="insertrm" method="post"onsubmit="return validateForm()"> 
                <input id="status" type="hidden" value=" ${status}" name="status" readonly>
                <input id="action" type="hidden" value="cash" name="action" readonly>
                <input id="totalPayed" type="hidden" value="${totalNumber}" name="totalPayed" readonly>
                <input type="hidden" value="${room.roomNum}" name="roomnum" readonly>
                <input type="hidden" value="${sessionScope.manager.userName}" name="manager" readonly>
                <button type="submit" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4">Pay by Cash</button>
            </form>
        </div>
    </div>
</div>
</html>
