<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>History - Jotter</title>
</head>
<body>

<p>${error}</p>
<a href="HomePageServlet">Back to Homepage</a>

<h1>Deleted Items</h1>
<form action="/history" method="post">
    <c:forEach items="${assignments}" var="item">
        -${item.getName()}
        <button type="submit"  value="${item.getName()}" name="restore">Restore</button>
    </c:forEach>
</form>
</body>
</html>
