<%@ page import="Beans.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/genresList.jspf" %>

<%
    request.setCharacterEncoding("UTF-8");

%>
<jsp:useBean id="bookList" class="Beans.BookList" scope="page"/>
<% List<Book> currentBooks = null;

 String letter = request.getParameter("letter");
 String genreId = request.getParameter("genreId");
 String search = request.getParameter("search");
 String getAll = request.getParameter("getAll");
 String searchType = request.getParameter("searchType");
 if (genreId != null) {
     Long genre = 0L;
     try {
         genre = Long.parseLong(request.getParameter("genreId"));
         currentBooks = bookList.getBooksByGenre(genre);
     } catch (Exception e) {
         e.printStackTrace();
     }
 } else if (letter != null) {
     currentBooks = bookList.getBooksByLetter(letter);
 } else if (search != null && !search.isEmpty() && searchType != null){
     currentBooks = bookList.searchBooks(search, searchType);
 } else if (getAll.equals("true")){
     currentBooks = bookList.getAllBooks();
 }
    session.setAttribute("currentBooks", currentBooks);%>

<div class="main">
    <p class="title">Список книг</p>
    <p class="text">Найдено книг: <%=currentBooks.size()%></p>
    <% for (Book book : currentBooks) { %>
    <div class="bookCase">
        <div class="title">
            <%=book.getName()%>
            <br><%=book.getAuthor()%>
        </div>
        <div>
            <img src="${pageContext.request.contextPath}/ShowImage?index=<%=currentBooks.indexOf(book)%>"
                 height="200" width="150" align="center">
        </div>
        <div style="color: white; text-align: center">
            <br><strong>ISBN: </strong><%=book.getIsbn()%>
            <br><strong>Издательство: </strong><%=book.getPublisher()%>
            <br><strong>Страниц: </strong><%=book.getPages()%>
        </div>
        <div>
            <a href="#" class="searchB">Читать</a>
        </div>

    </div>
    <%}%>


</div>