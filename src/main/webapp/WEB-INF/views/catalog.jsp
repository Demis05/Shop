<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <%@ include file="jspf/header.jspf" %>
                <title>Products</title>
        </head>

        <body>
            <div align="center">
                <h2>Products</h2>
                <form method="get" action="/products/search">
                    <input type="text" name="productId" />
                    <input type="submit" value="Search" />
                </form>

                <h3><a href="/products/creating">New Product</a></h3>
                <table border="1" cellpadding="5"  height="25"width="40%">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Name</th>
                        <th>Cost</th>
                        <th>Type</th>
                        <th>Brand</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.title}</td>
                            <td>${product.name}</td>
                            <td>${product.cost}</td>
                            <td>${product.type}</td>
                            <td>${product.brand}</td>
                            <td>
                                <a href="/products/editing?id=${product.id}">Edit</a>
                                <a href="/products/delete?id=${product.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>