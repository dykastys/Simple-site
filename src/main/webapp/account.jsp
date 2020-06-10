<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 03.06.2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my_account</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Personal account</pre>
    </h2>
    <br/>

    <hr>

        <c:choose>
            <c:when test="${not empty another}">
                <b>Name: <font color="#5f9ea0">${another.name}</font></b>
                <br/>
                <b>Phone: <font color="#5f9ea0">${another.phone}</font></b>
                <br/>
                <c:choose>
                    <c:when test="${empty another.age}">
                        <b>Age: </b>absent
                    </c:when>
                    <c:otherwise>
                        <b>Age: ${another.age}</b>
                    </c:otherwise>
                </c:choose>
            </c:when>

            <c:otherwise>
                <b>Name: <font color="#5f9ea0">${user.name}</font></b>
                <br/>
                <b>Phone: <font color="#5f9ea0">${user.phone}</font></b>
                <br/>
                <c:choose>
                    <c:when test="${empty user.age}">
                        <b>Age: </b>absent
                    </c:when>
                    <c:otherwise>
                        <b>Age: ${user.age}</b>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>

        <br/>

        <c:choose>
            <c:when test="${not empty another}">
                <c:if test="${not empty another.addedProducts}">
                    <br/>
                    <br/>
                    <b>Displayed products:</b>
                    <br/>
                    <br/>
                    <c:forEach items="${another.addedProducts}" var="entry">
                        <b>
                            <a href="${pageContext.request.contextPath}/product?id=${entry.key.id}">${entry.key.name}</a>
                        </b>
                            <br/>
                                ${entry.value}
                            <br/>
                            <br/>
                    </c:forEach>
                </c:if>
                <hr>
                <br/>
                <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
            </c:when>

            <c:otherwise>
                <c:if test="${not empty user.addedProducts}">
                    <br/>
                    <br/>
                    <b>Displayed products:</b>
                    <br/>
                    <br/>
                    <c:forEach items="${user.addedProducts}" var="entry">
                        <b>
                            <a href="${pageContext.request.contextPath}/product?id=${entry.key.id}">${entry.key.name}</a>
                        </b>
                            <br/>
                                ${entry.value}
                            <br/>
                            <a href="${pageContext.request.contextPath}/edit_product?id=${entry.key.id}">edit ${entry.key.name}</a>
                            <br/>
                            <br/>
                    </c:forEach>
                </c:if>
                <hr>
                <a href="${pageContext.request.contextPath}/edit_account"><b>edit account</b></a>
                <br/>
                <br/>
                <a href="${pageContext.request.contextPath}/authorization"><b>change account</b></a>
                <br/>
                <br/>
                <a href="${pageContext.request.contextPath}/add_product">add product</a>
                <br/>
                <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
            </c:otherwise>
        </c:choose>
</body>
</html>
