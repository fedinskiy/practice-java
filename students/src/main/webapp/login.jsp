<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 23.02.17
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h1>Вход в систему</h1>
    <a href="registration" >Регистрация</a>
    <form action="/students/login" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value="" placeholder="Input">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="" placeholder="Input">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
