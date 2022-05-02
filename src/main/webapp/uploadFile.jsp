<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 5/1/2022
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>

<p>${message}</p>

<h1>Upload File</h1>
<a href="HomePageServlet">Back to Homepage</a><br><br>
<form action="/UploadFile" method="post" enctype="multipart/form-data">

    <label for="newImage">Upload Image:</label>
    <input type="file" id="newImage" name="newImage" accept="image/*">
    <button type="submit" name="decision" value="uploadFile">Upload Image</button><br><br><br><br>
</form>


</form>
</body>
</html>
