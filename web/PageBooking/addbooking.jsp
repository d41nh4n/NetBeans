<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>Add Booking</title>
        <script src="https://cdn.tailwindcss.com"></script>
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
    <body>
        <%
   Date currentDate = new Date();
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
   String formattedDate = formatter.format(currentDate);
        %>

        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2>Add Booking</h2>
            <c:if test="${not empty error}">
                <h3 class="text-red-500">${error}</h3>
            </c:if>
            <form action="addbooking" method="post"  onsubmit="return validateDates()">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" required value="${customerName}"/><br/>

                <label for="roomNumber">Room Number:</label>
                <input type="text" id="roomNumber" name="roomNumber" required value="${roomNumber}"/><br/>

                <label for="dateIn">Date In:</label>
                <input type="date" id="dateIn" name="dateIn" required value="${dateIn}"/><br/>

                <label for="dateOut">Date Out:</label>
                <input type="date" id="dateOut" name="dateOut" required value="${dateOut}"/><br/>

                <input type="hidden" id="currentDateInput" name="currentDateInput" value="<%= formattedDate %>" readonly required>

                <label for="deposit">Deposit:</label>
                <select id="deposit" name="deposit">
                    <option value="0">None</option>
                    <option value="5000000" <c:if test="${deposit == 5000000}">selected</c:if>>5 million</option>
                    <option value="10000000" <c:if test="${deposit == 10000000}">selected</c:if>>10 million</option>
                    <option value="15000000" <c:if test="${deposit == 15000000}">selected</c:if>>15 million</option>
                    </select><br>

                    <label for="contact">Contact:</label>
                    <input type="text" id="contact" name="contact" required value="${contact}"/><br/>

                <input type="submit" name="submit" value="Add"/>
            </form>
        </div>
    </body>
</html>
