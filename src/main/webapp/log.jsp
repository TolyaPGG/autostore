<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.UsersBundle"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Логин</title>
    <link rel="stylesheet" href="rating/styles/log.css">
</head>
<body>

<div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

    <form method="post" action="login" class="form-signin">
        <h1 class="form-signin-heading text-muted">Ты сможешь войти?</h1>
        <input name="j_username" type="text" class="form-control" placeholder="Username" required="" autofocus="">
        <input name="j_password" type="password" class="form-control" placeholder="Password" required="">
        <input type="hidden" name="url"
               value="<% if (request.getParameter("url")!= null) {%><%=request.getParameter("url")%><%} else %>${requestScope['javax.servlet.forward.request_uri']}">
        <button class="btn btn-lg btn-danger btn-block" type="submit">
            Ша попробую
        </button>
        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">
            <strong><%=request.getAttribute("error")%>
            </strong>
        </div>
        <% }%>
    </form>

</div>
<script>


    $("#log").validate({
        onkeyup: false,
        rules: {
            username: {
                cache: false,
                required: true,
                minlength: 5,

            },
            password: {
                required: true,
                minlength: 5
            },
            agree: "required"
        },

        messages: {

            password: {
                required: "Это обязательное поле",
                minlength: "Минимальная длина 5"
            },
            username: {
                required: "Это обязательное поле",
                minlength: "Минимум 5 символов",
            },

        },


        submitHandler: function (form) {

            form.submit();
        }
    });</script>
</body>
</html>
