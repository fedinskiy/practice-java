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
<a href="lections" >Лекции</a>
<form action="list" method="post">
    <table border="1">
        <c:forEach items="${studentList}" var="studentItem">
            <tr>
                <td><c:out value="${studentItem.name}"></c:out></td>
                <td><c:out value="${studentItem.birthdate}"></c:out></td>
                <td><c:out value="${studentItem.sex}"></c:out></td>
                <td style="display:none;"><c:out value="${studentItem.id}"></c:out></td>
                <td> <input type="checkbox" name="chosen" id="chosen" value=<c:out value="${studentItem.id}"></c:out>></td>
            </tr>
        </c:forEach>
    </table>
        <%--<input type="submit" name="operation" value="edit">--%>
        <input type="submit" name="operation" value="delete">
</form>
</body>
</html>
