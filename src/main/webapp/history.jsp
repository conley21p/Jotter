<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>History - Jotter</title>
</head>
<body>

<p>${error}</p>

<h1>Deleted Items</h1>
    <c:forEach items="${assignments}" var="item">
        -${item.getName()}  <form action="editAssign" method="get"><input type="submit"  value="edit" name="${item.getName()}" /></form>
    </c:forEach>
</body>
</html>
