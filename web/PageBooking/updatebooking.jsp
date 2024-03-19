
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>Add Booking</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <script>
            function validateDates() {
                var dateIn = document.getElementById("dateIn").value;
                var dateOut = document.getElementById("dateOut").value;
                var today = new Date();

                if (dateIn < today) {
                    alert("Check-in date cannot be in the past.");
                    return false;
                }

                if (dateIn >= dateOut) {
                    alert("Date Out must be greater than Date In.");
                    return false;
                }

                return true;
            }
        </script>
    </head>
    <body class="bg-gray-100">
        <jsp:include page="../menu.jsp"/>
        <div class="flex items-center justify-center h-screen bg-gray-100">
            <div class="mx-16 flex-grow">
                <h2 class="text-2xl font-bold mb-4">Update Booking</h2>
                <c:if test="${not empty error}">
                    <h3 class="text-red-500">${error}</h3>
                </c:if>
                <form action="updatebooking" method="post" onsubmit="return validateDates()" class="space-y-4">
                    <div class="flex flex-col">
                        <label for="customerName" class="mb-1">Customer Name:</label>
                        <input type="text" id="customerName" name="customerName" required value="${booking.customerName}" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="flex flex-col">
                        <label for="roomNumber" class="mb-1">Room Number:</label>
                        <select id="roomNumber" name="roomNumber" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                            <c:forEach items="${room}" var="room">
                                <option value="${room.roomNum}">${room.roomNum}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="flex flex-col">
                        <label for="dateIn" class="mb-1">Date In:</label>
                        <input type="date" id="dateIn" name="dateIn" required value="${booking.dateIn}" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="flex flex-col">
                        <label for="dateOut" class="mb-1">Date Out:</label>
                        <input type="date" id="dateOut" name="dateOut" required value="${booking.dateOut}" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <div class="flex flex-col">
                        <label for="deposit" class="mb-1">Deposit:</label>
                        <select id="deposit" name="deposit" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                            <option value="0">None</option>
                            <option value="5000000" <c:if test="${booking.deposite == 5000000}">selected</c:if>>5 million</option>
                            <option value="10000000" <c:if test="${booking.deposite == 10000000}">selected</c:if>>10 million</option>
                            <option value="15000000" <c:if test="${booking.deposite == 15000000}">selected</c:if>>15 million</option>
                            </select>
                        </div>
                        <div class="flex flex-col">
                            <label for="contact" class="mb-1">Contact:</label>
                            <input type="text" id="contact" name="contact" required value="${booking.contact}" class="px-4 py-2 rounded border border-gray-300 focus:outline-none focus:border-blue-400">
                    </div>
                    <input type="submit" name="submit" value="Update" class="px-6 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
                </form>
            </div>
        </div>
    </body>
</html>
