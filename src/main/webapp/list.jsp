<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 22.10.2016
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="resources/main.css" type="text/css">
</head>
<body>
<form method="post">

    <table class="table">
        <caption>Fruits</caption>
        <tr>
            <th>Fruit</th>
            <th>Color</th>
            <th colspan="3">Calories</th>
        </tr>
        <c:forEach items="${fruits}" var="fruit">
            <tr>
                <td>${fruit.name}</td>
                <td>${fruit.color} </td>
                <td>${fruit.calories}</td>
                <td colspan="2"><a href="add?edit=${fruit.id}">Edit</a>
                    <a href="delete?id=${fruit.id}">Del</a>
                </td>
            </tr>
        </c:forEach>
        <tr class="bot">
            <td></td>
            <td></td>
            <td></td>
            <td><td><a href="add" class="add1">add</a></td></td>
        </tr>
    </table>


</form>
</body>
</html>
