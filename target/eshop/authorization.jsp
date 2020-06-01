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
        <form action="${pageContext.request.contextPath}/check" method="post">
            <label>
                <br/>
                    <b>
                        <pre> Login:</pre>
                    </b>
                        <input type="text" name="login" value="enter the login" size="20" maxlength="20">
                <br/>
                <br/>
                    <b>
                        <pre> Password:</pre>
                    </b>
                        <input type="text" name="password" value="enter the password" size="20" maxlength="20">
                <br/>
                <br/>
                    <input type="submit" value="check">
                <br/>
                <br/>
            </label>
        </form>

        <a href="create_the_account.jsp"><b>create new account</b></a>
        <br/>
        <a href="index.jsp"><b>main page</b></a>
    <hr>
</body>
</html>
