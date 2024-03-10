<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="room" value="${room}"/>
<c:set var="customer" value="${customer}"/>
<c:set var="history" value="${list}"/>
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
        <h2>Room Information:</h2>
        <ul>
            <li>Room Number: ${room.roomNum}</li>
            <li>Availability: ${room.available}</li>
            <li>Type ID: ${room.idType}</li>
            <li>Type Name: ${room.typeName}</li>
            <li>Price Per Month: ${room.pricePerMonth}</li>
            <li>Price Per Day: ${room.pricePerDay}</li>
            <li> Status Using:</li>
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
        </ul>
        <c:forEach var="user" items="${user.customers}">
            <h2>Customer Information:</h2>
            <ul>
                <li>Full Name: ${user.fullName}</li>
                <li>Date of Birth: ${user.dob}</li>
                <li>Sex: ${user.sex}</li>
                <li>Phone: ${user.phone}</li>
                <li>ID: ${user.id}</li>
                <li>Nationality: ${user.nationality}</li>
                <!-- Add other customer attributes as needed -->
            </ul>
        </c:forEach>
        <h2>History Pay</h2>
        <h3>Total Price: </h3>
        <span class="text-sky-400">0</span>/${room.usingRoom.priceTotal}
        <c:if test="${not empty history}">
            <c:forEach items="${history}" var="his">
                <ul>
                    <li>Date: ${his.datePay}</li>
                    <li>Money: ${his.money}</li>
                </ul>
            </c:forEach>
        </c:if>
        <c:choose>
            <c:when test="${empty room.usingRoom}">
                <a href="checkio?roomnum=${room.roomNum}&action=checkin">Check-in</a>
            </c:when>
            <c:otherwise>
                <a href="checkio?roomnum=${room.roomNum}&action=edit">Edit</a>
                <a href="checkio?roomnum=${room.roomNum}&action=checkout">Check-Out</a>
                <c:if test="${status == 'month'}">
                    <input type="button" value="Deposit"  onclick="openModelDeposit()"/>
                </c:if>
            </c:otherwise>
        </c:choose>
    </body>
    <!-- model deposit -->
    <div>
        <div id="Deposit" class="fixed inset-0 z-50 overflow-auto bg-gray-800 bg-opacity-50 flex justify-center items-center hidden">
            <div class="bg-white w-1/2 p-8 rounded-lg">
                <div class="flex justify-between">
                    <h2 class="text-lg font-bold">Pay Rent</h2>
                    <button class="text-gray-500 hover:text-gray-700" onclick="closeModelDeposit()">&times;</button>
                </div>
                    <h2>Amount money ${room.roomNum} have to pay for next month is:</h2> 
                    <input type="number" value="${room.pricePerMonth}" name="money"><br>
                    <input type="hidden" value="${room.roomNum}" name="roomnum"><br>
                    <a href="" class="">Pay with VNPay</a>
                    <a href="" class="">Pay by cash</a>
                    </select><br>
                </form>
            </div>
        </div>
    </div>
</html>
