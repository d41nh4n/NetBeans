<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>Add Booking</title>
        <style>
            body {
                font-size: small;
            }
        </style>
        <script>
            function validateDates() {
                var dateIn = document.getElementById("dateIn").value;
                var dateOut = document.getElementById("dateOut").value;

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
        <h2>Add Booking</h2>
        <form action="addbooking" method="post"  onsubmit="return validateDates()">
            <label for="customerName">Customer Name:</label>
            <input type="text" id="customerName" name="customerName" required/><br/>

            <label for="roomNumber">Room Number:</label>
            <input type="text" id="roomNumber" name="roomNumber" required/><br/>

            <label for="dateIn">Date In:</label>
            <input type="date" id="dateIn" name="dateIn" required/><br/>

            <label for="dateOut">Date Out:</label>
            <input type="date" id="dateOut" name="dateOut" required/><br/>

            <input type="hidden" id="currentDateInput" name="currentDateInput" value="<%= formattedDate %>" readonly required>

            <label for="deposit">Deposit:</label>
            <select id="deposit" name="deposit">
                <option value="0">None</option>
                <option value="5000000">5 million</option>
                <option value="10000000">10 million</option>
                <option value="15000000">15 million</option>
            </select><br>

            <label for="contact">Contact:</label>
            <input type="text" id="contact" name="contact" required/><br/>

            <input type="submit" name="submit" value="Add"/>
        </form>
    </body>
</html>
