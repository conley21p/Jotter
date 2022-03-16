<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Create an Account</h1>
<form method="post" action="/register">

    <label>Email:</label><br>
    <input type="email" id="email" name="email" required>

    <label>Username:</label><br>
    <input type="text" id="username" name="username" required>

    <label>Password:</label><br>
    <input type="password" id="password" name="password" required>

    <label>Confirm Password:</label><br>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <button type="submit">Create Account</button>

</form>
</body>
</html>
