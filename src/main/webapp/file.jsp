<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 4/6/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<form action="FileServlet" method="post">
    <h4>Upload a file: </h4>
    <input type="file" id = "file" name="file" accept="image/jpeg" required/>

    </label>
    <h4></h4><input type="submit" />
</form>
</body>
</html>
