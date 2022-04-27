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
    <input type="date" name="date" value="${CalObj.getDate().toString()}" pattern="yyyy-m-dd"/>
</label>
    <h4>Due Time:*</h4><label>
    <input type="time" name="time" value="${CalObj.getTime()}"/>
</label>
    <h4>description:</h4><label>
    <input type="text" name="description" value="${CalObj.getDescription()}"  />
</label>
    </label>
    <h4>course:</h4><label>
    <input type="text" name="course" />
</label>
    <h4>Completed:</h4><label>
    <input type="checkbox" name="status" id="status" value="completed" ${CalObj.getCompleted()!= "null" ? 'checked' : 'unchecked'}>
</label>
    <h4></h4><input type="submit" name="button" value="Update" />
    <input type="submit" name="button", value="Create Copy"/>
    <input type="submit" name="button", value="Delete"/>
    <input type="submit" name="button", value="Return To Home Page"/>
</form>

</body>
</html>
