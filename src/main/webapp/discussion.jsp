<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить обсуждение</title>
    <link rel="stylesheet" href="rating/styles/quests.css">
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-8 col-md-offset-2">

            <h1>Создать обсуждение</h1>

            <form action="addDiscuss" method="post">
                <div class="form-group has-error">

                    <input type="text" class="form-control" name="theme" id="theme"/>
                    <span class="help-block">Напишите автотему</span>
                </div>


                <div class="form-group">
                    <p style="color: #eeeeee">Титул</p>  <span class="require">*</span>
                    <input id="title" type="text" class="form-control" name="title"/>
                </div>

                <div class="form-group">
                    <p style="color: #eeeeee">Описание</p>
                    <textarea name="text" id="text" rows="5" class="form-control"></textarea>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">
                        создать
                    </button>
                    <button type="reset" class="btn btn-default">
                        сбросить
                    </button>
                </div>

            </form>
        </div>

    </div>
</div>
</body>
</html>
