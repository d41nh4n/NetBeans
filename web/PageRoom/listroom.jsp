<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="functions" uri="/WEB-INF/tlds/myFunctions" %>
<c:set var="numberRoom" value="${requestScope.numberRoom}"/>
<c:set var="numberUsingRoom" value="${requestScope.numberUsingRoom}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <script src="https://cdn.tailwindcss.com"></script>
        <title>Page Room's List</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>

        <h1 class=" flex text-3xl justify-center my-10">Page Room's List</h1>
        <h1 class="text-xl mx-16 my-5">
            Number Room is Using:
            <span class="text-sky-400">${numberUsingRoom}</span>/${numberRoom}
        </h1>

        <div class="grid grid-flow-row gap-8 text-neutral-600 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 mx-16 my-20 flex"> 
            <c:forEach var="room" items="${list}">
                <div class="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-white-1000 dark:border-white-1000">
                    <a href="inforroom?roomnum=${room.roomNum}">
                        <!--                        <img class="rounded-t-lg" src="#" alt="Default Image" />-->
                        <h1>${room.roomNum}</h1>
                    </a>
                    <div class="p-5">
                        <c:choose>
                            <c:when test="${room.usingRoom eq null}">
                                <label id="status" >Type:  ${room.typeName}</label><br>
                                <label id="status" >Status:  ${functions:convertAvailable(room.available)}</label><br>
                                <label id="bookinglist">Booking-list:   <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Booking</a></label><br>
                                <p class="mb-3 font-normal text-gray-700 dark:text-gray-400"></p>
                            </c:when>
                            <c:otherwise>
                                <label id="status" >Type:  ${room.typeName}</label><br>
                                <label id="status" >Status:  ${functions:convertAvailable(room.available)}</label><br>
                                <label id="number-user" >Number-user:  ${room.usingRoom.numberUser}</label><br>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
