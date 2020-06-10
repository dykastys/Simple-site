<%@ page import="ru.kushnarev.models.Dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authorization</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Authorization</pre>
    </h2>

    <hr>
        <form action="${pageContext.request.contextPath}/authorization" method="post">
            <label>
                <br/>
                    <b>
                        <pre>Login:</pre>
                    </b>
                        <input type="text" name="login" value="enter the login" size="20" maxlength="20">
                <br/>
                <br/>
                    <b>
                        <pre>Password:</pre>
                    </b>
                        <input type="text" name="password" value="enter the password" size="20" maxlength="20">
                <br/>
                <br/>
                    <input type="submit" value="check">
                <br/>
                <br/>
            </label>
        </form>

        <a href="${pageContext.request.contextPath}/create_account"><b>create new account</b></a>
        <br/>
        <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
    <hr>

    <c:if test="${not empty error}">
        <br/>
        <br/>
        <font color="red"><%=request.getAttribute("error")%></font>
    </c:if>
</body>
</html>
