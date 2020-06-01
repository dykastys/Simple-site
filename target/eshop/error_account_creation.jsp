<%--
  Created by IntelliJ IDEA.
  User: chako
  Date: 31.05.2020
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>account_creation_error</title>
</head>
<body>
    <br/>
    <h2>
        <pre>       Creating the account</pre>
    </h2>

    <hr>
    <form action="${pageContext.request.contextPath}/add_account" method="post">
        <label>
            <br/>
                <b>
                    <pre>Enter the Login:</pre>
                </b>
                    <input type="text" name="login" value="enter the login" size="20" maxlength="20">
            <br/>
                <b>
                    <pre>Enter the Password:</pre>
                </b>
                    <input type="text" name="password1" value="enter the password" size="20" maxlength="20">
            <br/>
                <b>
                    <pre>Repeat the Password:</pre>
                </b>
                    <input type="text" name="password2" value="repeat the password" size="20" maxlength="20">
            <br/>
            <br/>
                <input type="submit" value="register">
            <br/>
            <br/>
                <a href="index.jsp"><b>main page</b></a>
        </label>
    </form>
    <hr>

    <br/>
    <br/>
    <b><font color="red">passwords don't match</font></b>
</body>
</html>
