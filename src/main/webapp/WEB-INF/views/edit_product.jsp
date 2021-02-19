<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <%@ include file="jspf/header.jspf" %>
                <title>Edit Product</title>
        </head>

        <body>
            <div align="center">
                <h2>Edit Product</h2>
                <form:form action="update" method="post" modelAttribute="product" enctype="multipart/form-data">
                    <table border="0" cellpadding="5">
                        <tr>
                            <td>ID: </td>
                            <td>${product.id}
                                <form:hidden path="id" />
                            </td>
                        </tr>
                        <tr>
                            <td>Name: </td>
                            <td>
                                <form:input path="name" />
                            </td>
                        </tr>
                        <tr>
                            <td>Title: </td>
                            <td>
                                <form:input path="title" />
                            </td>
                        </tr>
                        <tr>
                            <td>Cost: </td>
                            <td>
                                <form:input path="cost" />
                            </td>
                        </tr>
                        <tr>
                            <td>Type: </td>
                            <td>${product.type}
                                <form:hidden path="type" />
                            </td>
                        </tr>
                        <tr>
                            <td>Brand : </td>
                            <td>${product.brand}
                                <form:hidden path="brand" />
                            </td>
                        </tr>
                        <tr>
                            <td>Select a image to upload</td>
                            <td><input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Save"></td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </body>

        </html>