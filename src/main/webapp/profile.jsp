<%@ page import="User.User" %>
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

<%--    <script>--%>
<%--        function confirmDelete () {--%>
<%--            alert("howdy");--%>
<%--            var agree = confirm("Are you sure you want to delete your account?");--%>
<%--            if (agree) {--%>
<%--                return true;--%>
<%--            } else {--%>
<%--                return false;--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>

<%--    <button onClick="confirmDelete">Delete Account</button><br>--%>
    <%--TODO confirm submission--%>
    <button type="submit" name="decision" value="deleteAccount" onClick="confirmDelete">Delete Account</button><br>

    <button type="submit" name="decision" value="sortCalendar">Sort Current Calendar</button><br>
</form>
<a href="/DownloadServlet">Export Current Calendar</a><br>
<a href="/ImportCalendar">Import a Calendar</a><br>

</form>
</body>
</html>
