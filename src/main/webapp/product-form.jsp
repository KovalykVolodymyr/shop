<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>
            <head>
                <title>Product Management Application</title>
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
                    <c:if test="${product != null}">
                        <form action="update" method="post">
                        </c:if>
                        <c:if test="${product == null}">
                            <form action="insert" method="post">
                            </c:if>
                            <table border="1" cellpadding="5" style="border:
                                none;">
                                <caption>
                                    <h2>
                                        <c:if test="${product != null}">
                                            Edit product
                                        </c:if>
                                        <c:if test="${product == null}">
                                            New product
                                        </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${product != null}">
                                    <input type="hidden" name="id" value="<c:out
                                        value='${product.id}' />" />
                                </c:if>
                                <tr>
                                    <th style="border: none;">Name: </th>
                                    <td style="border: none;">
                                        <input type="text" name="title"
                                            size="45"
                                            value="<c:out
                                            value='${product.title}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th style="border: none;">Price: </th>
                                    <td style="border: none;">
                                        <input type="text" name="price"
                                            size="45"
                                            value="<c:out
                                            value='${product.price}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"
                                        style="border: none;">
                                        <input type="submit" value="Save" />
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </body>
            </html>