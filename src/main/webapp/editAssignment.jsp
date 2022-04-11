<%--
  Created by IntelliJ IDEA.
  User: conle
  Date: 4/11/2022
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Assignment</title>
</head>
<body>
<form action="editAssign" method="post">
    <h4>Name:*</h4><label>
    <input type="text" name="name" value="${CalObj.getName()}"/>
</label>
    <h4>Due Date:*</h4><label>
    <input type="date" name="date" value="${CalObj.getDate()}" />
</label>
    <h4>Due Time:*</h4><label>
    <input type="time" name="time" value="${CalObj.getTime()}"/>
</label>
    <h4>description:</h4><label>
    <input type="text" name="description" value="${CalObj.getDescription()}" pattern="" />
</label>
    <h4></h4><input type="submit" />
</form>

</body>
</html>
