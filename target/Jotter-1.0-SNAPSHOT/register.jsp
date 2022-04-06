<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register - Jotter</title>
</head>
<body>

<p>${error}</p>

<h1>Create an Account</h1>
<form action="RegisterServlet" method="post">

    <label>Email:</label>
    <input type="email" id="email" name="email" value="${email}" required><br>

    <label>Username:</label>
    <input type="text" id="username" name="username" value="${username}" required><br>

    <label>Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label>Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br>

    <button type="submit">Create Account</button>

</form>
</body>
</html>
