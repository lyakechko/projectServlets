<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${sessionScope.getOrDefault("fullName","Авторизация")}</title>
</head>
<body>
<h1>
</h1>
<p>Добро пожаловать: ${sessionScope.getOrDefault("fullName","")}</p>
<p>Нас: ${applicationScope.getOrDefault("allUsers","Данные не получены")} !</p>
<style>
    body {
        background: #505350;
        color: #f9fcf9;
    }
</style>
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
<link rel="stylesheet" href="/WEB-INF/css/main.css"/>
</body>
</html>

