<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile - Jotter</title>
</head>
<body>

<p>${error}</p>

<h1>Profile</h1>
<form action="/profile" method="post">

    <button type="submit" name="decision" value="deleteAccount">Delete Account</button>
    <button type="submit" name="decision" value="changeUsername">Change Username</button>

</form>
<form>

</form>
</body>
</html>
