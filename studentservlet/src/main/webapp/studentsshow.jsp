<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List</h1>
<div>
    <table style="width:100%">
    <c:forEach items="${studentList}" var="student">

        <tr>
            <td><c:out value="${student.name}"></c:out></td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>