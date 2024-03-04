<%-- 
    Document   : addcustomer
    Created on : Feb 25, 2024, 1:20:22 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="customer" value="${requestScope.customer}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Input Form</title>
        <script>
            const selectElement = document.getElementById('nationality');
            const options = selectElement.querySelectorAll('option');

            for (const option of options) {
                if (option.value === ${customer.nationality}) {
                    option.selected = true;
                }

                option.textContent = option.value;
            }
        </script>
    </head>

    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mt-10"> 
            <h1>${customer.fullName}</h1>
            <div class="">
                <form action="updatecustomer" method="post">
                    <label for="fullname">Full Name: </label><br>
                    <input type="text" id="fullname" name="fullname" value="${customer.fullName}"><br>

                    <label for="dob">Date of Birth:</label><br>
                    <input type="date" id="dob" name="dob" value="${customer.dob}"><br>

                    <label for="sex">Sex:</label><br>
                    <c:choose>
                        <c:when test="${customer.sex == true}">
                            <input type="radio" id="male" name="sex" value="true" checked>
                            <label for="male" >Male</label>
                            <input type="radio" id="female" name="sex" value="false">
                            <label for="female">Female</label><br>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" id="male" name="sex" value="true" >
                            <label for="male" >Male</label>
                            <input type="radio" id="female" name="sex" value="false" checked>
                            <label for="female">Female</label><br>
                        </c:otherwise>
                    </c:choose>

                    <label for="phone">Phone:</label><br>
                    <input type="text" id="phone" name="phone" value="${customer.phone}"><br>

                    <label for="id">ID:</label><br>
                    <input type="text" id="id" name="id" value="${customer.id}" readonly><br>

                    <label for="searchCountry">Search Country:</label><br>
                        <select name="nationality" required><br>
                        <c:forEach items="${countries}" var="country">
                             <option value="${country}" <c:if test="${customer.nationality == country}">selected</c:if>>${country}</option>
                        </c:forEach>     
                    </select> <br>
                    <input type="submit" value="Submit">

                </form>
            </div>
        </div>
    </body>
</html>


