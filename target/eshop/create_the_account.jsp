<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create_the_account</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Creating the account</pre>
    </h2>

    <hr>
        <form action="${pageContext.request.contextPath}/create_account" method="post">
            <label>
                <br/>
                    <b>
                        <pre>Enter the Login:</pre>
                    </b>
                    <input type="text" name="login" value="" size="20" maxlength="20">
                <br/>
                    <b>
                        <pre>Enter the Password:</pre>
                    </b>
                        <input type="password" name="password1" value="" size="20" maxlength="20">
                <br/>
                    <b>
                        <pre>Repeat the Password:</pre>
                    </b>
                        <input type="password" name="password2" value="" size="20" maxlength="20">
                <br/>
                    <b>
                        <pre>Enter the Phone number:</pre>
                    </b>
                        <input type="text" name="phone" value="" size="20" maxlength="20">
                <br/>
                <br/>
                    <input type="submit" value="register">
                    <br/>
                    <br/>
                    <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
            </label>
        </form>
    <hr>

    <c:if test="${not empty error}">
        <br/>
        <br/>
        <b><font color="red">${pageContext.request.getAttribute("error")}</font></b>
    </c:if>
</body>
</html>
