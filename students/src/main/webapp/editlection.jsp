<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fedinskiy
  Date: 24.02.17
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lection</title>
</head>
<body>
<form action="lections" method="post"  acceptCharset="UTF-8">
    <table border="1">
            <tr>
                <td><input type="text" name="name" id = "name" value="<c:out value="${lection.name}"></c:out>" autofocus /></td>
                <td><input type="text" name="date" id = "date" value="<c:out value="${lection.date}"></c:out>" autofocus /></td>
                <td style="display:none;"><input type="text" name="id" id = "id" value="<c:out value="${lection.id}"></c:out>"  /></td>
                <td style="display:none;"><input type="text" name="group_id" id = "group_id" value="<c:out value="${lection.groupId}"></c:out>"  /></td>
            </tr>
    </table>
    <input type="submit" name="operation" value="savelection">
</form>
</body>
</html>
