<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register - Jotter</title>
</head>
<body>

<p>${error}</p>
<a href="/login">Back to Login</a><br>

<h1>Create an account</h1>
<form action="/register" method="post">

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${email}" required><br>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${username}" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br>

    <button type="submit">Create account</button>

</form>
</body>
</html>
