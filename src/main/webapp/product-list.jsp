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
                    <caption><h2>List of Products</h2></caption>


                    <table border="1" cellpadding="5"
                        style="border-collapse:collapse; width: 100%;">

                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                        <c:forEach var="Product" items="${listProduct}">
                            <tr>
                                <td><c:out value="${Product.id}" /></td>
                                    <td><c:out value="${Product.title}" /></td>
                                        <td><c:out value="${Product.price}"
                                                /></td>
                                            <td>
                                                <a href="edit?id=<c:out
                                                    value='${Product.id}' />"><img
                                                        src="https://storage.googleapis.com/assets.moneymade.io/images/logos/Edit_Notepad_Icon.svg"
                                                        alt="Edit" style="width:
                                                        24px; height:24px;"/></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="delete?id=<c:out
                                                    value='${Product.id}' />"><img
                                                        src="https://storage.googleapis.com/assets.moneymade.io/images/logos/delete.svg"
                                                        alt="Delete"
                                                        style="width:
                                                        24px; height:24px;"/></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </body>
                    </html>