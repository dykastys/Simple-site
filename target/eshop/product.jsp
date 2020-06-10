<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product_${product.name}</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Product</pre>
    </h2>
    <br/>

    <hr>
        <b>Name</b> - ${product.name}<br/>
        <b>Price</b> - ${product.price} $
        <br/>
        <br/>
        <b>Seller</b> - <a href="${pageContext.request.contextPath}/account?name=${product.user.name}">${product.user.name}</a>
    <hr>

    <br/>
    <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
</body>
</html>