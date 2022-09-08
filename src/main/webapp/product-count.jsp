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
                    <div>
                        <p>Product title: <c:out
                                value="${selectedProduct.title}" /></p>
                            <p>Product price: <c:out
                                    value="${selectedProduct.price}" /></p>
                            </div>
                            <table border="1" cellpadding="5"
                                style="border-collapse:collapse; width: 100%;">
                                <form action="buying-count" method="post">
                                    Provide products count:&nbsp;
                                    <input type="text" name="count" size="45"
                                        value="<c:out value='${productsCount}'
                                        />"
                                    />
                                    <br/><br/>
                                            <input type="submit" value="Submit"
                                                />
                                        </form>
                                    </table>
                                </div>
                            </body>
                        </html>