<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>САНТЕХНИКА</title>
</head>
<body>

<link rel="stylesheet" href="/WEB-INF/css/main.css"/>
<h1 class="h1" align="center">Добро пожаловать на сайт сантехники</h1>
<br/>
<style>
    body {
        background: #505350;
        color: #f9fcf9;
    }
</style>
<style>
    .wrapper {
        background-color: #cdc6c6;
        list-style-type: none;
        padding: 0;
        border-radius: 3px;
    }

    .form-row {
        display: flex;
        justify-content: flex-end;
        padding: .5em;
    }

    .form-row > label {
        padding: .5em 1em .5em 0;
        flex: 1;
    }

    .form-row > input {
        flex: 2;
    }

    .form-row > input,
    .form-row > button {
        padding: .5em;
    }

    .form-row > button {
        background: gray;
        color: white;
        border: 0;
        size: 100px;
    }
</style>

<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
    $(window).on('load', function () {
        var $preloader = $('#page-preloader'),
            $spinner   = $preloader.find('.spinner');

        $spinner.fadeOut();
        $preloader.delay(350).fadeOut('slow');
    });
</script>
<div id="page-preloader">
    <span class="spinner"></span>
</div>

<form action="mainPage-servlet" method="post">
    <ul class="wrapper">
        <li class="form-row">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="loginAut" placeholder="Логин" maxlength="30">
        </li>
        <li class="form-row">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="passwordAut" placeholder="Пароль" maxlength="30">
        </li>
        <li class="form-row">
            <button width="70" type="submit">Войти</button>
        </li>
    </ul>
</form>
<form action="mainPage-servlet" method="get">
    <ul class="wrapper">
        <li class="form-row">
            <button width="70" type="submit">Регистрация</button>
        </li>
    </ul>
</form>
<form action="mainPage-servlet" method="get">
    <ul class="wrapper">
        <li class="ui-button">
            <input type="radio" id="ru" name="localEn" value="1" checked/>EN
            <input type="radio" id="en" name="localRu" value="0" />RU
        </li>
    </ul>
</form>
</body>
</html>