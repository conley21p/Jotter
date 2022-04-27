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
<form action="profile.jsp" method="post" enctype="multipart/form-data">
    <%--Code for import--%>
    <h4>Upload a file: </h4>
    <input type="file" id = "file" name="file" accept="file/txt" required/>
    <button type="submit" name="import" value="import">Import</button>
</form>
</body>
</html>
