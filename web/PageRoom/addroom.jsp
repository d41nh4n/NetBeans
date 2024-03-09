<%-- 
    Document   : addroom
    Created on : Feb 27, 2024, 9:56:06 PM
    Author     : Dai Nhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="functions" uri="/WEB-INF/tlds/myFunctions" %>
<c:set value="${sessionScope.booking}" var="booking"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Booking</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            function searchByName(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/Assignment/seachbyajax",
                    type: "get",
                    data: {
                        txt: txtSearch
                    },
                    success: function (data) {
                        var row = document.getElementById("content");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        // Handle error if needed
                    }
                });
            }

            function openModal() {
                document.getElementById('searchModal').classList.remove('hidden');
            }

            function closeModal() {
                document.getElementById('searchModal').classList.add('hidden');
            }

            function closeModal2() {
                document.getElementById('addModal').classList.add('hidden');
            }


            function openModal2() {
                document.getElementById('searchModal').classList.add('hidden');
                document.getElementById('addModal').classList.remove('hidden');
            }
        </script>
    </head>
    <body>
        <h2>Add Booking</h2>
        <!-- Button trigger modal -->
        <button type="button" class=" bg-gray-400 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded"  onclick="openModal()">
            Add New Customer
        </button><br>
        <!-- Session User -->
        <c:forEach var="user" items="${sessionScope.users}" varStatus="loop">
            <h3>Customer ${loop.index + 1}</h3>
            <div class="flex space-x-4">
                <p>ID: ${user.id}</p>
                <p>Full Name: ${user.fullName}</p>
                <p>Date of Birth: <fmt:formatDate pattern="MM-dd-yyyy" value="${user.dob}" /></p>
                <p>Gender: ${functions:convertGender(user.sex)}</p>
                <p>Phone: ${user.phone}</p>
                <p>Nationality: ${user.nationality}</p>
            </div>
        </c:forEach>
        <form action="checkin" method="post">
            <input type="hidden" name="id" value="${booking.id}">
            <label for="datein">Date In:</label>
            <input type="date" id="datein" name="datein" required value="${booking.dateIn}"><br>
            <label for="dateout">Date Out:</label>
            <input type="date" id="dateout" name="dateout" required value="${booking.dateOut}"><br>
            <label for="deposit">Deposit:</label>
            <select id="deposit" name="deposit">
                <option value="0">None</option>
                <option value="5000000" <c:if test="${booking.deposite == '5000000'}">selected</c:if>>5 million</option>
                <option value="10000000"  <c:if test="${booking.deposite == '10000000'}">selected</c:if>>10 million</option>
                <option value="15000000"  <c:if test="${booking.deposite == '15000000'}">selected</c:if>>15 million</option>
                </select><br>
            <c:choose>
                <c:when test="${ not empty booking}">
                    <input type="hidden" name="roomnum" value="${booking.roomNumber}">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="roomnum" value="${sessionScope.roomnum}">
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Submit">
        </form>
    </body>
    <!-- Search User Modal -->
    <div id="searchModal" class="fixed inset-0 z-50 overflow-auto bg-gray-800 bg-opacity-50 flex justify-center items-center hidden">
        <div class="bg-white w-1/2 p-8 rounded-lg">
            <div class="flex justify-between">
                <h2 class="text-lg font-bold">Search Customers</h2>
                <button class="text-gray-500 hover:text-gray-700" onclick="closeModal()">&times;</button>
            </div>
            <label class="mt-4 block">Search</label>
            <input oninput="searchByName(this)" type="text" value="" name="search" class="w-50% px-4 py-2 border rounded-md">
            <button type="button" class="btn btn-secondary" onclick="openModal2()"> <!-- Thêm </button> ở đây -->
                Add
            </button>
            <div id="content" class="mt-4 text-sm w-full">
                <!-- Search results will be displayed here -->
            </div>
        </div>
    </div>
    <!-- Add User Modal -->
    <div id="addModal" class="fixed inset-0 z-50 overflow-auto bg-gray-800 bg-opacity-50 flex justify-center items-center hidden">
        <div class="bg-white w-1/2 p-8 rounded-lg">
            <div class="flex justify-between">
                <h2 class="text-lg font-bold">Add</h2>
                <button class="text-gray-500 hover:text-gray-700" onclick="closeModal2()">&times;</button>
            </div>
            <label class="mt-4 block">Add new customer</label>
            <form action="addcus" method="post">
                <label for="firstname">First Name: </label><br>
                <input type="text" id="firstname" name="firstname" required><br>

                <label for="lastname">Last Name:</label><br>
                <input type="text" id="lastname" name="lastname" required><br>

                <label for="dob">Date of Birth:</label><br>
                <input type="date" id="dob" name="dob" required><br>

                <label for="sex">Sex:</label><br>
                <input type="radio" id="male" name="sex" value="true">
                <label for="male">Male</label>
                <input type="radio" id="female" name="sex" value="false">
                <label for="female">Female</label><br>

                <label for="phone">Phone:</label><br>
                <input type="text" id="phone" name="phone" required><br>

                <label for="id">ID:</label><br>
                <input type="text" id="id" name="id" required><br>

                <label for="searchcountry">Search Country:</label><br>
                <select name="nationality" required><br>
                    <c:forEach items="${sessionScope.countries}" var="country">
                        <option value="${country}" >${country}</option>
                    </c:forEach>     
                </select><br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</html>
