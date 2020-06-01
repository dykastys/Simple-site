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
    <b>Products:</b><br/>
    <c:if test="${empty db}">
        <br/>
        <b>
            <pre><font color="#d2691e">    no products available</font></pre>
        </b>
    </c:if>
    <c:forEach items="${db}" var="entry">
        <br/>
        <b>
            <a href=${entry.key}>${entry.value.id}. ${entry.value.name}</a>
        </b>
    </c:forEach>

    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/add_product">Add the product</a>
    <hr>
</body>
</html>
