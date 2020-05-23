<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/user" method="post">
        Imie:
        <input type="text" name="name" required>
        Nazwisko:
        <input type="text" name="surname" required>
        Login:
        <input type="text" name="login" required>
        Password:
        <input type="password" name="password" required>
        Email:
        <input type="email" name="email" required>
        <input type="submit" value="Wyślij">
    </form>

</body>
</html>
