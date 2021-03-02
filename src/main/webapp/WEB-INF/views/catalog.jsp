<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="java">

        <head>
            <%@ include file="jspf/header.jspf" %>
                <title>Products</title>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src="https://sdk.amazonaws.com/js/aws-sdk-2.847.0.min.js"></script>
                <script src="js/s3Image.js"></script>
        </head>

        <body>
            <div align="center">
                <h2>Products</h2>
                <form method="get" action="/products/search">
                    <input type="text" name="productId" />
                    <input type="submit" value="Search" />
                </form>

                <h3><a href="/shop/products/creating">New Product</a></h3>
                <table border="1" cellpadding="5" height="25" width="40%">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Name</th>
                        <th>Cost</th>
                        <th>Type</th>
                        <th>Brand</th>
                        <th>Image</th>
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
                                <script>
                                    testing(${ product.imagePath });
                                </script>
                            </td>
                            <td>
                                <a href="/shop/products/editing?id=${product.id}">Edit</a>
                                <a href="/shop/products/delete?id=${product.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>