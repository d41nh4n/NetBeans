<%-- 
    Document   : chekout
    Created on : Mar 12, 2024, 3:55:43 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bill</title>
        <style type="text/css">
            table {
                border: 0;
            }
            table td {
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <h1>Bill</h1>
            <br/>
            <form action="athorizepayment" method="post">
                <table>
                    <tr>
                        <td>Number Room:</td>
                        <td><input type="text" name="roomnum" value="${roomNum}" /></td>
                    </tr>
                    <tr>
                        <td>Service</td>
                        <td><input type="text" name="service" value="Monthly room fee" /></td>
                    </tr>
                    <tr>
                        <td>Total Amount:</td>
                        <td><input type="number" name="total" value="${money}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Checkout" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>