<%--
  Created by IntelliJ IDEA.
  User: conle
  Date: 2/25/2022
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Assignment - Jotter</title>
</head>
<body>
<h1>Do you want to add another assignment?</h1>
<form action="${pageContext.request.contextPath}/AddAssignmentServlet">
    <input type="submit" value="Yes" />
</form>
<form action="${pageContext.request.contextPath}/HomePageServlet">
    <input type="submit" value="No" />
</form>


</body>
</html>
