<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Внимание!</title>
</head>

<body>

<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<link rel="stylesheet" href="/WEB-INF/css/main.css"/>
<style>
    body {
        background: #505350;
        color: #f9fcf9;
    }
</style>
<p align="center" style="background-color:DodgerBlue; color: black" width:100;>Произошла ошибка: </p>
<h2>"${pageContext.request.getAttribute("message")}"</h2>
</body>
</html>
