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
    </head>
    <body>
        <form action="editroom" method="post">
            <label for="datein">Date In:</label>
            <input type="date" id="datein" name="datein" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${room.usingRoom.datein}' />">
            <label for="dateout" >Date Out:</label>
            <input type="date" id="dateout" name="dateout" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${room.usingRoom.dateout}' />"><br>
            <label for="deposit">Deposit:</label>
            <select id="deposit" name="deposite">
                <option value="0">None</option>
                <option value="5000000" <c:if test="${room.usingRoom.deposite == '5000000'}">selected</c:if>>5 million</option>
                <option value="10000000"  <c:if test="${room.usingRoom.deposite == '10000000'}">selected</c:if>>10 million</option>
                <option value="15000000"  <c:if test="${room.usingRoom.deposite == '15000000'}">selected</c:if>>15 million</option>
            </select><br>
            <input type="hidden" name="roomnum" value="${room.roomNum}">
            <input type="submit" name="Update">
        </form>
    </body>
</html>
