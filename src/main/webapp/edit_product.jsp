<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 09.06.2020
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit_${requestScope.product.name}</title>
</head>
<body>

    <br/>
    <h2>
        <pre>       Edit product <font color="#d2691e">${requestScope.product.name}</font></pre>
    </h2>
    <br/>

    <hr>

        <c:choose>
            <c:when test="${not empty delete}">
                <b>
                    Are u sure about deleting the <font color="#d2691e">${requestScope.delete.name}</font>
                </b>
                <br/>
                <br/>
                <form action="${pageContext.request.contextPath}/delete_product?id=${requestScope.delete.id}&del=ok" method="post">
                    <input type="submit" value="apply">
                </form>
                <form action="${pageContext.request.contextPath}/delete_product?id=${requestScope.delete.id}&del=cancel" method="post">
                    <input type="submit" value="cancel">
                </form>

                <hr>
            </c:when>

            <c:otherwise>
                <form action="${pageContext.request.contextPath}/edit_product?id=${requestScope.product.id}" method="post">
                    <b>
                        Product name: <font color="#a52a2a">${requestScope.product.name}</font>
                        <br/>
                    </b>
                    Enter new product name if you want
                    <br/>
                    <input type="text" name="name" size="20" maxlength="20">
                    <br/>
                    <br/>

                    <b>
                        Product price: <font color="#a52a2a">${requestScope.product.price}</font>
                        <br/>
                    </b>
                    Enter new price if wou want
                    <br/>
                    <input type="text" name="price" size="20" maxlength="20">
                    <br/>
                    <br/>
                    <input type="submit" value="apply">
                </form>

                <hr>

                <br/>
                <form action="${pageContext.request.contextPath}/delete_product?id=${requestScope.product.id}" method="post">
                    <input type="submit" value="delete">
                </form>
            </c:otherwise>
        </c:choose>

    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/account?name=${user.name}"><b>back</b></a>
    <br/>
    <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
    <br/>
    <br/>

    <c:if test="${not empty name_success}">
        <font color="#228b22">${requestScope.name_success}</font>
        <br/>
    </c:if>
    <c:if test="${not empty price_success}">
        <font color="#228b22">${requestScope.price_success}</font>
        <br/>
    </c:if>
    <br/>

    <c:if test="${not empty error_name}">
        <font color="red">${requestScope.error_name}</font>
        <br/>
    </c:if>
    <c:if test="${not empty error_price}">
        <font color="red">${requestScope.error_price}</font>
        <br/>
    </c:if>
</body>
</html>
