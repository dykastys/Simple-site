<%@ page import="ru.kushnarev.models.Dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main_page</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Site For Free Ads</pre>
    </h2>
    <br/>

    <hr>
    <c:choose>
        <c:when test="${empty user}">
            <p align="right">
                <b>Unnamed User</b>
            </p>
            <p align="right"><a href="${pageContext.request.contextPath}/authorization">
                <b>authorization</b></a>
            </p>
        </c:when>
        <c:otherwise>
            <b>
                Account: <a href="${pageContext.request.contextPath}/account?name=${user.name}">
                            <font color="#5f9ea0">${user.name}</font>
                         </a>
            </b>
            <br/>
                <a href="${pageContext.request.contextPath}/authorization"><b>change account</b></a>
            <br/>
        </c:otherwise>
    </c:choose>
    <br/>
    <br/>
    <b>Products:</b>
    <br/>
    <c:choose>
        <c:when test="${empty db}">
            <br/>
            <b>
                <pre><font color="#d2691e">    no available products</font></pre>
            </b>
        </c:when>
        <c:otherwise>
            <c:forEach items="${db}" var="entry">
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/product?id=${entry.id}">
                                ${entry.name} - ${entry.price}$
                        </a>
                    </li>
                </ul>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <br/>
    <a href="${pageContext.request.contextPath}/add_product">Add the product</a>
    <hr>
</body>
</html>
