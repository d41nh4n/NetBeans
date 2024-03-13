<%-- 
    Document   : updateroom
    Created on : Mar 1, 2024, 11:07:09 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${room}" var="room"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Import Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100">
        <div class="container mx-auto p-4">
            <form action="editroom" method="post" class="max-w-lg mx-auto bg-white p-8 rounded shadow-lg">
                <div class="mb-4">
                    <label for="datein" class="block text-gray-700">Date In:</label>
                    <input type="date" id="datein" name="datein" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${room.usingRoom.datein}' />" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                </div>
                <div class="mb-4">
                    <label for="dateout" class="block text-gray-700">Date Out:</label>
                    <input type="date" id="dateout" name="dateout" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${room.usingRoom.dateout}' />" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                </div>
                <div class="mb-4">
                    <label for="deposit" class="block text-gray-700">Deposit:</label>
                    <select id="deposit" name="deposite" class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                        <option value="0">None</option>
                        <option value="5000000" <c:if test="${room.usingRoom.deposite == '5000000'}">selected</c:if>>5 million</option>
                        <option value="10000000" <c:if test="${room.usingRoom.deposite == '10000000'}">selected</c:if>>10 million</option>
                        <option value="15000000" <c:if test="${room.usingRoom.deposite == '15000000'}">selected</c:if>>15 million</option>
                        </select>
                    </div>
                    <input type="hidden" name="roomnum" value="${room.roomNum}">
                <button type="submit" name="Update" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 focus:outline-none focus:bg-blue-600">Update</button>
            </form>
        </div>
    </body>
</html>
