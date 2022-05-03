<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - Jotter</title>
</head>
<body>
<p>${error}</p>

<h1>Login to Jotter</h1>
<form action="/login" method="post">

    <label>Username:</label>
    <input type="text" id="username" name="username" value="${username}" required><br>

    <label>Password:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Login</button>

</form>
<a href="/register">Register</a><br>

</body>
</html>
