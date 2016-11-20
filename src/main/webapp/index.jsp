<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.UsersBundle"/>

<html>
<head>
    <title>AUTOSTORE</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/MyIndex.css"/>">
    <link rel="stylesheet" type="text/css" href="rating/styles/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">


</head>

<body>

<div class="jumbotron">
    <h1>Лучший поиск сервисов и автомагазинов!</h1>
    <p>Здесь вы найдете рекомендации по поиску деталей и услуг в своем городе.</p>
    <p><a class="btn btn-primary btn-lg" href="/autostore/InProgress.jsp" role="button">Больше</a></p>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>


</html>
