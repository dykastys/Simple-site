<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_the_product</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Add the product</pre>
    </h2>
    <br/>

    <hr>
        <form action="${pageContext.request.contextPath}/add_product" method="post">
            <label>
                    <b>
                        <pre>Name:</pre>
                    </b>
                        <input type="text" name="name" size="20" maxlength="20">
                <br/>
                    <b>
                        <pre>Price:</pre>
                    </b>
                        <input type="text" name="price" size="20" maxlength="20"><br/>
                <br/>
                    <input type="submit" value="add">
            </label>
        </form>

        <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
    <hr>

    <c:if test="${not empty error}">
        <br/>
        <br/>
        <font color="red">${pageContext.request.getAttribute("error")}</font>
    </c:if>
</body>
</html>
