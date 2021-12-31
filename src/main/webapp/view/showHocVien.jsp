<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 31/12/2021
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/home?action=create">Create</a></button>
<form action="/home?action=search" method="post">
    <input name="search">
    <button type="submit">Search</button>
</form>
<table border="1">
    <c:forEach items="${listHV}" var="hv">
        <tr>
            <td>${hv.id}</td>
            <td>${hv.name}</td>
            <td>${hv.getAddress()}</td>
            <td>${hv.date}</td>
            <td>${hv.phone}</td>
            <td>${hv.email}</td>
            <td>${hv.className}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
