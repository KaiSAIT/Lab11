<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Home nVentory</h1>
        <form method="POST" action="register">
            <div>
                <h2>Register for Account</h2>
                <label>Email:</label>
                <input type="email" name="email" value="${email}">
                <br>
                <label>Password:</label>
                <input type="password" name="password" value="${password}">
                <br>
                <label>First Name:</label>
                <input type="text" name="first_name" value="${firstName}">
                <br>
                <label>Last Name:</label>
                <input type="text" name="last_name" value="${lastName}">
            </div>
            <div>
                <input type="submit" value="Complete Registration">
            </div>
        </form>
    </body>
</html>
