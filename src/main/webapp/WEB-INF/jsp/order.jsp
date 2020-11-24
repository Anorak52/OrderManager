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
        <th>UserName</th>
        <th>user_id</th>
        </thead>
        <c:forEach items="${allOrders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.username}</td>
                <td>${order.users}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Main</a>
</div>
</body>
</html>