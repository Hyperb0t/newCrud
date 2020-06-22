<%--
  Created by IntelliJ IDEA.
  User: Vitaly
  Date: 01.03.2020
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.css"/>">
</head>
<body>
<div class="col-10 mx-auto mt-5">
    <h3 class="mb-2">All users</h3>
    <table class="table">
        <thead class="table-hover">
        <th scope="col">id</th>
        <th scope="col">email</th>
        <th scope="col">password</th>
        <th scope="col">country</th>
        <th scope="col">gender</th>
        <th scope="col">birthday</th>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getCountry()}</td>
                <td>${user.getGender()}</td>
                <td>${user.getBirthday()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
