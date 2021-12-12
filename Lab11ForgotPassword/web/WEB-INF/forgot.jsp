<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <p>Please enter your email address to retrieve your password.</p>
        <br>
        <label>Email Address:</label>
        <input type="email" name="email">
        <input type="submit" value="Submit" id="reset">
        <input type="hidden" value="Reset" name="action">
    </body>
</html>
