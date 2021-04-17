<%@ page import="java.text.ParseException" %>
<%@ page import="Beans.Book" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/genresList.jspf" %>

<%
    request.setCharacterEncoding("UTF-8");
    Long genreId = 0L;
    try {
        genreId = Long.parseLong(request.getParameter("genreId"));
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<jsp:useBean id="bookList" class="Beans.BookList" scope="page"/>

<div class="main">
    <p class="title">Список книг</p>
    <table cellpadding="10px" style="font-size: 12px;color: #c92200">
        <% for (Book book : bookList.getBooksByGenre(genreId)) { %>
        <tr>
            <td style="width:10%;">PICTURE</td>
            <td class="title"style="width:40%">
                <%=book.getName()%>
                <br><%=book.getAuthor()%>
            </td>
            <td style="width: 20%; height: 70px" class="text">
                <br><strong>ISBN: </strong><%=book.getIsbn()%>
                <br><strong>Издательство: </strong><%=book.getPublisher()%>
                <br><strong>Страниц: </strong><%=book.getPages()%>
            </td>
            <td style="width: 10%"><a href="#" class="searchB">Читать</a></td>
        </tr>
        <%}%>
    </table>


</div>