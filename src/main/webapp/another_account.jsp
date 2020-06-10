<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 08.06.2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>account_<%=request.getAttribute("name")%></title>
</head>
<body>
<br/>
<h2>
    <pre>       Personal account</pre>
</h2>
<br/>

<hr>
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

<br/>


<c:if test="${not empty user.addedProducts}">
    <br/>
    <c:forEach items="user.addedProducts" var="entry">
        <b>
            <a href="product.jsp">${user.addedProducts.key.name}</a>
            <br/>
                ${user.addedProducts.value}
            <br/>
            <br/>
        </b>
    </c:forEach>
</c:if>
<hr>
<a href="edit_account.jsp"><b>edit account</b></a>
<br/>
<br/>
<a href="add_the_product.jsp">add product</a>
<br/>
<a href="index.jsp"><b>main page</b></a>
</body>
</html>
