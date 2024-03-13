<%-- 
    Document   : receipt
    Created on : Mar 12, 2024, 9:18:07 PM
    Author     : Dai Nhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment Receipt</title>
        <style type="text/css">
            table {
                border: 0;
            }
            table td {
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <h1>Payment Done. Thank you for purchasing our products</h1>
            <h2>Receipt Details:</h2>
            <form action="insertrm" method="get">
                <table>
                    <tr>
                        <td><b>Merchant:</b></td>
                        <td>Company ABC Ltd.</td>
                    </tr>
                    <tr>
                        <td><b>Payer:</b></td>
                        <td><input type="text" name="payerName" value="${payer.firstName} ${payer.lastName}" readonly></td>      
                    </tr>
                    <tr>
                        <td><b>Description:</b></td>
                        <td><input type="text" name="description" value="${transaction.description}" readonly></td>
                    </tr>
                    <tr>
                        <td><b>Total:</b></td>
                        <td><input type="text" name="total" value="${transaction.amount.total} USD" readonly></td>
                    </tr>          
                    <tr>
                        <td colspan="2"><input type="submit" value="Apply"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
