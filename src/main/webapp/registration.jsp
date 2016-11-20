<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="rating/styles/register.css" rel="stylesheet">

    <title>Регистрация</title>
</head>
<body>

<form  method="post" action="register" id="rf" class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Введии!!!!!</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fname">Firstame</label>
            <div class="col-md-4">
                <input id="fname" name="fname" type="text" placeholder="ВВеди!! имя" class="form-control input-md" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="lname">Lastname</label>
            <div class="col-md-4">
                <input id="lname" name="lname" type="text" placeholder="ВВеди!! фамилию" class="form-control input-md" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" placeholder="ВВеди!! мыло" class="form-control input-md" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="username">Username</label>
            <div class="col-md-4">
                <input id="username" name="username" type="text" placeholder="ВВеди!! ник" class="form-control input-md" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" type="text" placeholder="ВВеди!! пароль" class="form-control input-md" required="">

            </div>
        </div>
        <div class=" container radio form-group">
            <label>
                <input type="radio" name="status" id="statQ" value="discusser" checked>
                Новичек в автоделе
            </label>
            <label>
                <input type="radio" name="status" id="statA" value="solutioner">
                Опытный водитель

            </label>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="signup"></label>
            <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-success">Регаться хачу</button>
            </div>
        </div>


    </fieldset>
</form>


<script src="webjars/jquery-validation/1.14.0/jquery.validate.min.js"></script>
<script>
    $("#rf").validate({
        rules: {
            fname: {
                required: true,
                minlength: 3
            },
            lname: {
                required: true,
                minlength: 3
            },
            email: {
                required: true,
                email: true
            },
            username: {
                required: true,
                minlength: 3,
                remote: {
                    url: "checkusername",
                    type: "post"
                }
            },
            password: {
                required: true,

            },

        },
    messages:{
        fname: {
            required: "Имя обязательно для заполнения",
            minlength: "длина имени не менее 3",
        },
        lname: {
            required: "Фамилия обязательна для заполнения",
            minlength: "длина фамилии не менее 3",
        },
        email: {
            required: "email обязателен для заполнения",
            email: "неверный введен email",
        },
        username: {
            remote:"Такой ник уже используется",
            required: "ник обязателен для заполнения",
            minlength: "длина ника не менее 3",
        },
        password: {
            required: "пароль обязателен для заполнения",

        },
    }

    });
</script>
</body>
</html>
