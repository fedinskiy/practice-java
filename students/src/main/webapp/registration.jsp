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
    <title>Registration</title>
</head>
<body>
<div>
    <h1>Регистрация</h1>
    <form action="registration" method="post">
        <table>
            <tr><td>
                <label for="login">Choose name for registration:</label>
            </td></tr>
            <tr><td>
          <input type="text" name="login" id="login" value="" placeholder="Input">
            </td></tr>
            <tr><td>
                <label for="password">Password:</label>
            </td></tr>
            <tr><td>
                <input type="password" name="password" id="password" value="" placeholder="Input">
            </td></tr>
            <tr><td>
          <input type="submit" value="Submit">
            </td></tr>
        </table>
    </form>
</div>
</body>
</html>
