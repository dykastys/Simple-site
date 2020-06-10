<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 03.06.2020
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit_account</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Edit account</pre>
    </h2>
    <br/>

    <hr>
        <form action="${pageContext.request.contextPath}/edit_account" method="post">
            <b>
                Your account name: <a href="${pageContext.request.contextPath}/account?name=${user.name}">${user.name}</a>
                <br/>
            </b>
                Enter new account name if you want
                <br/>
                <input type="text" name="login" size="20" maxlength="20">
                <br/>
                <br/>

            <b>
                Your phone: ${user.phone}
            </b>
                <br/>
                Enter new phone if you want
                <br/>
                <input type="text" name="phone" size="20" maxlength="20">
                <br/>

            <c:choose>
                <c:when test="${not empty user.age}">
                    <b>Age: ${user.age}</b>
                </c:when>
                <c:otherwise>
                    <b>Age: </b>absent
                </c:otherwise>
            </c:choose>
                <br/>
                Enter new age if you want
                <br/>
                <input type="text" name="age" size="20" maxlength="20">
                <br/>
                <br/>

                Enter last password and new password if you want to change it
                <br/>
                <input type="text" name="lastPass" value="last password" size="20" maxlength="20">
                <br/>
                <input type="text" name="newPass" value="new password" size="20" maxlength="20">
                <br/>
            <br/>
            <input type="submit" value="apply">
        </form>
    <hr>
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/account?name=${user.name}"><b>back</b></a>
    <br/>
    <a href="${pageContext.request.contextPath}/"><b>main page</b></a>
    <br/>
    <br/>
    <c:if test="${not empty login_success}">
        <b>
            <font color="#228b22">${login_success}</font>
        </b>
        <br/>
    </c:if>
    <c:if test="${not empty phone_success}">
        <b>
            <font color="#228b22">${phone_success}</font>
        </b>
        <br/>
    </c:if>
    <c:if test="${not empty age_success}">
        <b>
            <font color="#228b22">${age_success}</font>
        </b>
        <br/>
    </c:if>
    <c:if test="${not empty password_success}">
        <b>
            <font color="#228b22">${password_success}</font>
        </b>
        <br/>
    </c:if>
    <br/>
    <br/>
    <c:if test="${not empty phone_error}">
        <b>
            <font color="red">${phone_error}</font>
        </b>
        <br/>
    </c:if>
    <c:if test="${not empty age_error}">
        <b>
            <font color="red">${age_error}</font>
        </b>
        <br/>
    </c:if>
    <c:if test="${not empty password_error}">
        <b>
            <font color="red">${password_error}</font>
        </b>
        <br/>
    </c:if>
</body>
</html>
