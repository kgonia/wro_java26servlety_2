<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.sda.java26.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<%@ include file="header.jsp" %>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<fmt:setLocale value="${param.locale}"/>

<fmt:setBundle basename="translations"/>

<%
    List<Student> students = new ArrayList<>();

    students.add(new Student("Jan", "Kowalski", 4));
    students.add(new Student("Karol", "Nowak", 3));
    students.add(new Student("Tomasz", "Karolak", 2));

    pageContext.setAttribute("students", students);
%>
<body>

<div class="container">
    <table class="table table-striped">
        <tr>
            <th><fmt:message key="student.table.header.name"/> </th>
            <th><fmt:message key="student.table.header.surname"/> </th>
            <th><fmt:message key="student.table.header.year"/> </th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.yearOfStudy}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--<%@ include file="footer.jsp" %>--%>
</body>
</html>
