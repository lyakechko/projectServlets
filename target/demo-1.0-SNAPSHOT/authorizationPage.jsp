<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${sessionScope.getOrDefault("fullname","Авторизация")}</title>
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


<table border="1" cellpadding="5" cellspacing="5" method="get">
    <tr>
        <th>UsInf ID</th>
        <th>UsInf Name</th>
        <th>UsInf Surname</th>
        <th>UsInf Resident</th>
    </tr>

    <c:forEach var="userInfo" items="${userInfoList}">
        <tr>
            <td>${userInfo.id}</td>
            <td>${userInfo.name}</td>
            <td>${userInfo.suname}</td>
            <td>${userInfo.resident}</td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="authorizedZone-servlet.do?page=${currentPage - 1}">Предыдущая</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="3" cellspacing="3" >
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="authorizedZone-servlet.do?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="authorizedZone-servlet.do?page=${currentPage + 1}">Следующая</a></td>
</c:if>
</body>
</html>
