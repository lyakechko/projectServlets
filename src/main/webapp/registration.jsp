<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Регистрация</title>
</head>
<body>
<h1 class="h1" align="center">Заполните анкету</h1>
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
        border-radius: 5px;
    }

    .form-row {
        display: flex;
        justify-content: flex-end;
        padding: .5em;
    }

    .form-row > label {
        padding: .20em 10em .20em 0;
        flex: 1;
    }

    .form-row > input {
        flex: 5;
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

    .ui-button {
        padding: .5em;
    }
</style>
<link rel="stylesheet" href="/WEB-INF/css/main.css"/>
<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
    $(window).on('load', function () {
        var $preloader = $('#page-preloader'),
            $spinner = $preloader.find('.spinner');

        $spinner.fadeOut();
        $preloader.delay(350).fadeOut('slow');
    });
</script>
<div id="page-preloader">
    <span class="spinner"></span>
</div>
<form action="registrationPage-servlet" method="post">
    <ul class="wrapper">
        <li class="form-row">
            <label for="name">Имя:</label>
            <input type="text" id="name" name="name" placeholder="Имя" maxlength="30">
        </li>
        <li class="form-row">
            <label for="surname">Фамилия:</label>
            <input type="text" id="surname" name="surname" placeholder="Фамилия" maxlength="30">
        </li>
        <li class="form-row">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" placeholder="Логин" maxlength="30">
        </li>
        <li class="form-row">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" placeholder="Пароль" maxlength="30">
        </li>
        <li class="form-row">
            <label for="passwordDouble">Повторите пароль:</label>
            <input type="password" id="passwordDouble" name="passwordDouble" placeholder="Повторите пароль"
                   maxlength="30">
        </li>
        <li class="form-row">
            <label for="codeForAdmin">Введите код администратора, если кода нет,оставьте поле пустым:</label>
            <input type="password" id="codeForAdmin" name="codeForAdmin" placeholder="Код администратора (если есть)"
                   maxlength="30">
        </li>
        <li class="ui-button">
            <label for="resident">Резиденство:</label>
            <input type="radio" id="resident" name="resident" value="1"/>Да
            <input type="radio" id="notResident" name="resident" value="0" checked/>Нет
        </li>
        <li class="form-row">
        </li>
        <li class="form-row">
            <button type="submit">Зарегистрироваться</button>
        </li>
    </ul>
</form>
<form action="registrationPage-servlet" method="get">
    <ul class="wrapper">
        <li class="form-row">
            <button type="submit">Назад</button>
        </li>
    </ul>
</form>
</body>
</html>
