<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    TO STRONA Z UŻYTKOWNIKAMI
    <br>
    <div class="container">
        <table class="table table-striped">
            <tr>
                <th>Imie </th>
                <th>Nazwisko </th>
                <th>Login </th>
                <th>Email </th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
