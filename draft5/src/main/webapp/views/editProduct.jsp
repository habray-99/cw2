<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/5/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Edit Product</h1>
        <form method="POST" action="EditProductDAO">
            <input type="hidden" name="productId" value="${product.id}">
            <label for="name">Name:</label>
            <input type="text" name="name" value="${product.name}"><br>
            <label for="description">Description:</label>
            <textarea name="description">${product.description}</textarea><br>
            <label for="price">Price:</label>
            <input type="text" name="price" value="${product.price}"><br>
            <tlabel for="stock">Stock:</tlabel>
            <input type="text" name="Stock" value="${product.stock}"><br>
            <label for="catId">Category:</label>
            <input type="text" name="catID" value="${product.catId}"><br>
            <input type="submit" value="Save">
        </form>
</body>
</html>
