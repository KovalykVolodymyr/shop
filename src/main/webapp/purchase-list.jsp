<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>
            <head>
                <title>Shop Application</title>
                <style>                   
                    a:hover {
                        
                        color:#ff0000;
                    }
                </style>
            </head>
            <body style=" margin: 0px;">
                <center>

                    <div style=" display: flex;
                        justify-content: flex-start;
                        align-items: center;
                        background-color: #000;
                        color: #fff; padding: 15px;
                        font-size: 20;">
                        <a href="list" style=" text-decoration: none;
                            color: #fff;">Products</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="new" style=" text-decoration: none;
                            color: #fff;">Create Product</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="buying" style=" text-decoration: none;
                            color: #fff;">Shop</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="card" style=" text-decoration: none;
                            color: #fff;">Your Card</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="purchase-history" style=" text-decoration:
                            none;
                            color: #fff;">Hisory Shoping</a>
                    </div>
                </center>
                <div align="left" style=" width:600px; padding-left: 40px;">
                    <table border="2" cellpadding="25" style="border: 0px
                        solid; width: 100%;">
                        <caption><h2 style="text-align: left;">Bying History</h2></caption>
                        <c:forEach var="basketItem" items="${listPurchase}">
                            <tr>
                                <td style="border: 0px
                                    solid; padding: 0px;">
                                    <table border="1" cellpadding="5"
                                        style="border-collapse:collapse;
                                        padding: 0px;">
                                        <c:forEach var="prd"
                                            items="${basketItem.items}">
                                            <tr>
                                                <th>Product id</th>
                                                <th>Products count</th>
                                                <th>Total price</th>

                                            </tr>
                                            <tr>
                                                <td><c:out
                                                        value="${prd.productId}"
                                                        /></td>
                                                    <td><c:out
                                                            value="${prd.count}"
                                                            /></td>
                                                        <td style="border: 0px
                                                            solid;"><c:out
                                                                value="${basketItem.totalPrice}"
                                                                /></td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </body>
                    </html>