<%-- 
    Document   : cart
    Created on : Oct 18, 2017, 9:10:00 AM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            #cart{
                margin-left: 690px;
            }
        </style>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <a href="../"><button type="button" class="btn btn-info">Back To Chart</button></a>
        <div id="cart"><a href="../logout"><button type="button" class="btn btn-danger">Logout</button></a></div><br />
        <table style="width:75%" class="table table-hover table-responsive">
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${baseCart}" var="b">
                <tr>
                    <td>${b.name}</td>
                    <td>${b.price}</td>
                    <td><a href="../deleted/${b.productId}"><button type="button" class="btn btn-danger">Remove</button></a></td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
