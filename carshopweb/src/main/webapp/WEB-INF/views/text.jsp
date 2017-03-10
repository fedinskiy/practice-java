<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 06.03.17
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text</title>
</head>
<body>
    <a href="text/showfullcar">Показать</a>
    <h1>${myText}</h1>
    <h2>${car.model}</h2>
    <form action="/text" method="post">
        <input name="param1" type = text>
        <button type=submit >GO</button>
    </form>

    <spring:form method="post"  modelAttribute="car" action="text/showfullcar">
        <spring:button>Next Page</spring:button>
    </spring:form>

</body>
</html>
