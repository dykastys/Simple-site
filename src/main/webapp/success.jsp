<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>

    <c:if test="${not empty creation}">
        <br/>
        <h3>
            <font color="#006400">The account <font color="#d2691e">${requestScope.creation.name}</font> was created successfully</font>
        </h3>
        <br/>

        <a href="${pageContext.request.contextPath}/add_product"><b>add product</b></a>
        <br/>
    </c:if>

    <c:if test="${not empty add}">
        <br/>
        <h3>
            <font color="#006400">The product <font color="#d2691e">${requestScope.add.name}</font> was successfully added to the site</font>
        </h3>
        <br/>

        <a href="${pageContext.request.contextPath}/add_product"><b>add another product</b></a>
        <br/>
    </c:if>

    <c:if test="${not empty delete}">
        <br/>
        <h3>
            <font color="#006400">The product <font color="#d2691e">${requestScope.delete.name}</font> was successfully deleted from the site</font>
        </h3>
        <br/>

        <a href="${pageContext.request.contextPath}/account?name=${user.name}"><b>back to account</b></a>
        <br/>
    </c:if>

    <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
</body>
</html>
