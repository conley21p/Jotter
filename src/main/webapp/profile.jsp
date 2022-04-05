<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile - Jotter</title>
</head>
<body>

<p>${error}</p>

<h1>Profile</h1>
<form action="ProfileServlet" method="post">

    <label>Username:</label>
    <input type="text" id="username" name="username" value="${username}" required><br>

    <button type="submit">Delete Account</button>

</form>
</body>
</html>
