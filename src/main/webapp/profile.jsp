<%@ page import="utils.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile - Jotter</title>
</head>
<body>

<p>${error}</p>

<h1>Profile</h1>
<form action="/profile" method="post">

    <label>Username of any account you want to delete:</label>
    <input type="text" id="username" name="username" value="${username}" >
    <button type="submit">Delete account</button><br>
    <button type="submit" name="decision" value="deleteAccount">Delete Loaded account: <%=UserController.getUser()%></button>
    <button type="submit" name="decision" value="changeUsername">Change Username</button>

</form>
<form>

</form>
</body>
</html>
