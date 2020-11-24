<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>Username</th>
        <th>registration date</th>
        <th>creature Date</th>
        <th>comment</th>
        </thead>
        <c:forEach items="${allOrder}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.username}</td>
                <td>${order.registrationData}</td>
                <td>${order.creatureDate}</td>
                <td>${order.orderComment}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Main</a>
</div>
</body>
</html>