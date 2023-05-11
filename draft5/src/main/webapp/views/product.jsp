<%@ page import="com.controllers.P_C_Getter" %>
<%@ page import="com.models.Products" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/7/2023
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/CSS.css">
    <script src="./js/jquery-3.6.0.js"></script>
    <script src="./js/scripts.js"></script>
</head>
<body>
<div class="row row-cols-1 row-cols-md-5 g-4">
    <%
        P_C_Getter getter = new P_C_Getter();
        List<Products> products = getter.getProducts();
        if (products != null) {
            for (Products product : products) {%>
    <div class="col">
        <div class="card h-100">
<%--            <img src="<%=product.getProduct_photo()%>" class="card-img-top" alt="..." loading="lazy">--%>
            <img src="<%=request.getContextPath()%>/views/photos/Screenshot.png" class="card-img-top" alt="..."  loading="lazy">
            <div class="card-body">
                <h5 class="card-title"><%=product.getProduct_name()%></h5>
                <p class="card-text"><%=product.getProduct_price()%></p>
            </div>
            <div class="card-footer">
                <form method="POST" action="<%=request.getContextPath()%>/Add2CartDAO">
                    <input type="hidden" name="productId" value="<%= product.getProduct_id()%>">
                    <input type="number" name="quantity" min="1" max="<%=product.getStock()%>" value="1">
                    <input type="submit" value="Add to Cart">
                </form>
            </div>
        </div>
    </div>
    <%}

    } else {%>
    <div>
        <p>
            Sorry, the product that you are searching for is not available
        </p>
    </div>
    <%}
    %>
</div>
</body>
</html>
