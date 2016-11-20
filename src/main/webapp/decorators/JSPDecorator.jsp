<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.UsersBundle"/>



<!DOCTYPE html>
<html lang="en">
<head>
    <title><decorator:title/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">


    <meta charset="utf-8">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">


    <link rel="icon" href="favicon.ico">
    <link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">



    <link href="webjars/jquery-ui/1.11.3/jquery-ui.css" rel="stylesheet">
    <link href="webjars/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet"/>
    <link href="rating/styles/jumboron.css" rel="stylesheet">
    <link href="rating/styles/font-awesome.css" rel="stylesheet">
    <link href="/rating/styles/font-awesome.css" rel="stylesheet">

    <decorator:head/>
    <script src="https://use.fontawesome.com/488985dde4.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    <script src="webjars/jquery/1.11.1/jquery.js"></script>
    <script src="webjars/jquery-ui/1.11.3/jquery-ui.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/i18n/jquery-ui-i18n.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-growl/2.0.1/bootstrap-growl.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.3/js/tether.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/autostore">AutoStore</a>
        </div>
        <center>
            <div class="navbar-collapse collapse" id="navbar-main">
                <ul class="nav navbar-nav">
                    <li><a href="getQuests">Обсуждения</a>
                    </li>
                    <li><a href="/autostore/InProgress.jsp">Контакты</a>
                    </li>

                    </li>


                    <c:if test="${user==null}">
                        <li class="align-right">
                        <form method="post" action="login" class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" name="j_username" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="j_password" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-default"><i class="fa fa-address-book" aria-hidden="true"></i>Войти</button>
                        </form>
                        </li>
                        <li><a href="registration.jsp" class="btn btn-default ">Регистрация <i
                                class="fa fa-sign-in"></i></a></li>
                    </c:if>
                    <c:if test="${user!=null}">

                       <li><a href="logout" class="btn btn-default btn-outline btn-circle">Выйти <i
                            class="fa fa-sign-out"></i></a></li>
                        <li class="align-right" style="padding-left: 10px"><a class="btn btn-default btn-outline btn-circle"> ${user.username} </a></li>
                    </c:if>



                </ul>
            </div>
        </center>
    </div>
</div>


<div class="MyContent" style="padding-top: 10%">
    <decorator:body/>
</div>

<script>
    $(document).ready(function () {
        $("form").submit(function () {
            var btn = $(this).find("input[type=submit]:focus");
            $(btn).attr("disabled", "true");
        });
    });
</script>
</body>
</html>



