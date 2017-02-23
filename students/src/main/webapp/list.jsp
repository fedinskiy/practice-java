<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 23.02.17
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LIST</h1>
<table border="1">
    <c:forEach items="${studentlist}" var="studentItem">
        <tr>
            <td><c:out value="${studentItem.name}"></c:out></td>
            <td><c:out value="${studentItem.type}"></c:out></td>
            <td><c:out value="${studentItem.type}"></c:out></td>
            <td><c:out value="${studentItem.type}"></c:out></td>
            <td><c:out value="${studentItem.type}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
