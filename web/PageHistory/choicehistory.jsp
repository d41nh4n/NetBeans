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
        <style>
            .center {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16 center">
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                <a href="listhistory">History usingyoom</a>
            </button>
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline ml-4">
                <a href="listhistoryrm">History cash flow</a>
            </button>
        </div>
    </body>
</html>
