<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile - Jotter</title>
</head>
<body>

<p>${message}</p>

<h1>Profile</h1>
<a href="HomePageServlet">Back to Homepage</a><br><br>
<form action="/profile" method="post">

    <label for="newPassword">New Password:</label>
    <input type="text" id="newPassword" name="newPassword">
    <button type="submit" name="decision" value="changePassword">Change Password</button><br><br><br><br>

    <button type="submit" name="decision" value="deleteAccount" onClick="confirmDelete">Delete Account</button>
</form>
<a href="/ImportCalendarServlet">Import a Calendar</a><br>

</form>
</body>
</html>
