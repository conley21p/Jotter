<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - Jotter</title>
</head>
<body>
<%-- TODO Still need to work on error (If authentication does not work) --%>
<%-- <p>${error}</p> --%>

<h1>Login to Jotter</h1>
<form action="LoginServlet" method="post">

    <label>Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label>Password:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Login</button>

</form>
</body>
</html>
