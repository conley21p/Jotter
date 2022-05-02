<%--
  Created by IntelliJ IDEA.
  User: conle
  Date: 2/25/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Assignment - Jotter</title>
</head>
<body>
<h1>Enter new assignment Below:</h1>
<form action="AddAssignmentServlet" method="post">
    <h4>Name:*</h4><label>
    <input type="text" name="name" required/>
</label>
    <h4>Due Date:*</h4><label>
    <input type="date" name="date" required/>
</label>
    <h4>Due Time:*</h4><label>
    <input type="time" name="time" value="23:50" required/>
</label>
    <h4>description:</h4><label>
    <input type="text" name="description" />
</label>
    <h4>course:</h4><label>
    <input type="text" name="course" />
</label>
    <h4></h4><input type="submit" />
</form>
</body>
</html>
