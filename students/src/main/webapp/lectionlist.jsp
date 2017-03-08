<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 24.02.17
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Лекции</title>
</head>
<body>
<h1>Список лекций:</h1>
<form action="lections" method="post">
    <table border="1">
        <c:forEach items="${lectionlist}" var="lection">
            <tr>
                <td><c:out value="${lection.name}"></c:out></td>
                <td><c:out value="${lection.date}"></c:out></td>
                <td><a href="lections?operation=edit&id=<c:out value="${lection.id}"></c:out>"> редактировать</a> </td>
                <td> <input type="checkbox" name="chosen" id="chosen" value=<c:out value="${lection.id}"></c:out>></td>
            </tr>
        </c:forEach>
    </table>
    <%--<input type="submit" name="operation" value="edit">--%>
    <input type="submit" name="operation" value="delete">
</form>
</body>
</html>
