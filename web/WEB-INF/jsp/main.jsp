<%-- 
    Document   : main
    Created on : Oct 17, 2017, 1:21:40 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Welcome</h1>
        <table style="width:75%" class="table table-hover table-responsive">
            <caption>Select items to buy</caption>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>Action not implemented yet</td>
                </tr>
            </c:forEach>
            
        </table>

    </body>
</html>
