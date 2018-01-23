<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Twitter application login page</title>
</head>
<body>
<form action="login" method="post">
    <div>
        Login: <input type="text" name="username"/>
    </div>
    <div>
        Password: <input type="password" name="password"/>
    </div>
    <div>
        <input type="submit" value="Sign in"/>
    </div>
    <div>
        You don't have an account yet? <a href="register">Sign up</a>
    </div>
</form>
</body>
</html>