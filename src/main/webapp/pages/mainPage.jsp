<%@ page import="dbUtil.DbHelper" %>
<%@ page import="Beans.AuthorList" %>
<%@ page import="Beans.Author" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Welcome page</title>
    <link href="../css/main_style.css" rel="stylesheet" type="text/css">
</head>

<body class="body">

<div class="wrap">
    <!--wrap block-->

    <div class = "logo">
        <img src="../img/lib.png" height=100% hspace="10" vspace="10" align="middle"  alt="logo">               </div>

    <div class = "search">
        <p class="title"> Найти</p>
        <form name="search" action="    " method="  " class="search_form">
            <p><input type="text" class="colortext" name="search" size="80" value="">
                <input class="searchB" type="submit" name="Найти">
                <select>
                    <option>Название</option>
                    <option>Автор</option>
                    <option>Издательство</option>
                    <option>Жанр</option>
                </select>
            </p>
        </form>
    </div>

    <div class="list">
        <p class="title">Список авторов</p>
        <ul class="text">
            <%DbHelper helper = new DbHelper();
                AuthorList list = new AuthorList();
            %>
            <%for (Author a: list.getAuthors() ) { %>
            <li><a href style="color:orange"><%=a.getFull_name()%></a></li>
            <%}%>
        </ul>
        </p>
    </div>

    <div class="main">
        <p class="title">Список книг</p>
        <p class="text">Добро пожаловать в онлайн библиотеку. Это мой учебный проект на стеке:
        <ul class="text">
            <li>Java, JDBC, JSP, JSF, JavaMail</li>
        </ul>
        </p>
    </div>


    <div class="footer">
        Разработчик: Андрей Алёнкин, 2021 г, <a href="oxqq@ya.ru">oxqq@ya.ru</a>
    </div>
</div>
</body>
</html>
