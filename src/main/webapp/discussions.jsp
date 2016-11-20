<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.UsersBundle"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Обсуждения</title>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="rating/styles/quest.css">

</head>
<body>
<c:if test="${user.role=='DISCUSSER'}">
    <div class="container">
        <a href="discussion.jsp" class="btn btn-primary btn-success">Обсудить...</a>
    </div>

</c:if>
<c:forEach var="it" items="${discussions}">

    <div class="container">
        <div class="container">
            <section class="widget">

                <div class="widget-body">
                    <div class="post-user mt-n-xs">
                        <span class="thumb pull-left mr">
                            <img class="img-circle" src="http://bootdey.com/img/Content/user_2.jpg" alt="...">
                        </span>
                        <h5 class="mb-xs mt-xs">${it.author} </h5>
                        <p class="fs-mini text-muted">
                            <time>${it.date}</time>
                            &nbsp;</p>
                    </div>
                    <div class="widget-middle-overflow windget-padding-md clearfix bg-danger text-white">
                        <h3 class="mt-lg mb-lg">${it.theme} - ${it.title}</h3>
                        <ul class="tags text-white pull-right">
                        </ul>
                    </div>
                    <p class="text-light fs-mini mt-sm">${it.text} </p>
                </div>
            </section>
        </div>
        <c:if test="${user!=null}">
            <c:if test="${user.role=='DISCUSSER'}">
                <form method="post">
                    <div class="input-group">
                        <input type="text" class=" solution form-control" placeholder="Ответить"
                               id="solution${it.q_id}" name="text" type="text">
                        <span class="input-group-btn">
                                    <button id="${it.q_id}" class="btn btn-ans btn-default" type="button"><i
                                            class="fa fa-edit"></i></button>
                                </span>
                    </div>
                </form>
                <hr>
            </c:if>
        </c:if>
        <ul class="comments-list" id="result${it.q_id}">
        </ul>

    </div>
    <script>
        $(document).ready(function () {
            setInterval(function () {
                $.ajax({
                    url: "getAnswer",
                    method: "get",
                    data: {id:${it.q_id}},
                    dataType: "text",
                    success: function (data) {
                        $('#result${it.q_id}').html(data);
                    }
                });
            }, 1000)

        });

    </script>

</c:forEach>
<script>
    $('.btn-ans').click(function (event) {
        if ($("#solution" + event.target.id).val() != "") {
            $.ajax({
                url: "getAnswer",
                method: "POST",
                data: {id: event.target.id, text: $("#solution" + event.target.id).val()},
                dataType: "text",
                success: function () {
                    alert("Commited");
                    $("#solution" + event.target.id).val("");
                }
            })
        }
    })
</script>
</body>
</html>
