<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 22.02.17
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spisok</title>
</head>
<body>
<h1>Spisok</h1>

<table border="1">
    <c:forEach items="${userlist}" var="userItem">
        <tr>
            <td><c:out value="${userItem.name}"></c:out></td>
            <td><c:out value="${userItem.type}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
