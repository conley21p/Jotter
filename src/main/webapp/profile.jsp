<%@ page import="User.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile - Jotter</title>
</head>
<body>

<p>${message}</p>
<a href="HomePageServlet">Homepage</a><br>

<h1>Profile</h1>
<form action="/profile" method="post">

    <label for="newPassword">New Password:</label>
    <input type="text" id="newPassword" name="newPassword">
    <button type="submit" name="decision" value="changePassword">Change Password</button><br><br><br>

    <button type="submit" name="decision" value="deleteAccount" onClick="confirmDelete">Delete Account</button><br><br>

    <button type="submit" name="decision" value="sortCalendar">Sort Current Calendar</button><br>
</form>
<form action="DownloadServlet" method="get">
    <h3>Click below to download the current calendar.</h3>
    <input type="submit" value="Download" />
</form>
<a href="/ImportCalendar">Import a Calendar</a><br>

</form>
</body>
</html>
