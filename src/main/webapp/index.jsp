<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Welcome page</title>
    <link href="css/index_style.css" rel="stylesheet" type="text/css">
</head>

<body class="">
<div class="img_block1">
    <p style="text-align: center;"><img src="img/1984.jpeg" width="100" vspace="10" align="center" alt="1984"></p>
    <p style="text-align: center;"><img src="img/2033.jpg" width="100" vspace="10" align="center" alt="2033"></p>
    <p style="text-align: center;"><img src="img/2034.jpg" width="100" vspace="10" align="center" alt="2034"></p>
</div>

<div class="main">
    <div class="content">
        <p class="title">
            <span class="text"><img src="img/lib.png" width="250" hspace="10" vspace="10" align="middle"
                                    alt="logo"></span>
        </p>

        <p class="title">Онлайн библиотека</p>
        <p class="text">Добро пожаловать в онлайн библиотеку. Это мой учебный проект на стеке:
        <ul class="text">
            <li>Java, JDBC, JSP, JSF, JavaMail</li>
            <li>AJAX, Hibernate, Maven ...</li>
            <li>Проект тестировался на локальном сервере GlassFish</li>
            <li>База данных - Postgres, проект задеплоен в Heroku.</li>
            <li>Фронтенд на классическом HTML/CSS ...</li>
        </ul>
        </p>
        <p class="text">Проект является учебным, его дизайн и функционал периодически дорабатываются</p>
        <p class="text">Связаться с автором: <a href="oxqq@ya.ru">oxqq@ya.ru</a></p>
        <p>&nbsp;</p>
    </div>

    <div class="login_div">
        <p class="title"> Введите имя для авторизации в библиотеке</p>
        <form name="greeting" action="pages/mainPage.jsp" method="post" class="login_form">
            <p>
                <input type="text" class="colortext" name="username" size="20" value="">
                <input type="submit" name="Войти">
            </p>
        </form>
    </div>

    <div class="footer">
        Разработчик: Андрей Алёнкин, 2021 г, <a href="oxqq@ya.ru">oxqq@ya.ru</a>
    </div>

</div>

<div class="img_block2">
    <p style="text-align: center;"><img src="img/dogray.jpg" width="100" vspace="10" align="middle" alt="dogray"></p>
    <p style="text-align: center;"><img src="img/flow.jpg" width="100" vspace="10" align="middle" alt="flow"></p>
    <p style="text-align: center;"><img src="img/hoking.jpg" width="100" vspace="10" align="middle" alt="hoking"></p>

</div>

</body>
</html>