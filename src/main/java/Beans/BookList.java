package Beans;

import dbUtil.DbHelper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookList {
    private DbHelper helper = new DbHelper();
    private List<Book> books;
    public List<Book> getBooksByGenre(Long genreId) {
        if (books == null || books.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            books = helper.execute("SELECT a.fio as \"author\", b.image as \"image\", " +
                            "a.id as \"id\", a.birthday as \"birthday\", b.page_count as \"pages\"," +
                            " b.publish_year as \"year\",p.name as \"name\",b.name as \"bookName\"," +
                            " b.isbn as \"isbn\", g.id as \"genreId\", b.descr as \"descr\", b.rating as \"rating\"" +
                            " FROM book b " +
                            "LEFT JOIN genre g ON(b.genre_id = g.id) " +
                            "LEFT JOIN publisher p ON(b.publisher_id=p.id) " +
                            "LEFT JOIN author a ON(b.author_id=a.id) " +
                            "WHERE (g.id=?) " +
                            "ORDER BY a.fio " +
                            "LIMIT 5; ",
                    resSet -> buildBook(resSet), prepst -> prepst.setLong(1, genreId));
        }
        return books;
    }

    public List<Book> getBooksByLetter(String letter) {
        if (books == null || books.isEmpty()) {
            books = helper.execute("SELECT a.fio as \"author\", b.image as \"image\", " +
                            "a.id as \"id\", a.birthday as \"birthday\", b.page_count as \"pages\"," +
                            " b.publish_year as \"year\",p.name as \"name\",b.name as \"bookName\"," +
                            " b.isbn as \"isbn\", g.id as \"genreId\", b.descr as \"descr\", b.rating as \"rating\"" +
                            " FROM book b " +
                            "LEFT JOIN genre g ON(b.genre_id = g.id) " +
                            "LEFT JOIN publisher p ON(b.publisher_id=p.id) " +
                            "LEFT JOIN author a ON(b.author_id=a.id) " +
                            "WHERE (LOWER(b.name) LIKE(?))" +
                            "ORDER BY a.fio;",
                    resSet -> buildBook(resSet), prepst -> prepst.setString(1, "%"+letter.toLowerCase()+"%"));
        }
        return books;
    }

    public List<Book> searchBooks(String searching, String searchType) {
        String param;
        if (searchType.equals("name")) {
            param = "b.name";
        } else param = "a.fio";
        if (books == null || books.isEmpty()) {
            books = helper.execute("SELECT a.fio as \"author\", b.image as \"image\", " +
                            "a.id as \"id\", a.birthday as \"birthday\", b.page_count as \"pages\"," +
                            " b.publish_year as \"year\",p.name as \"name\",b.name as \"bookName\"," +
                            " b.isbn as \"isbn\", g.id as \"genreId\", b.descr as \"descr\", b.rating as \"rating\"" +
                            " FROM book b " +
                            "LEFT JOIN genre g ON(b.genre_id = g.id) " +
                            "LEFT JOIN publisher p ON(b.publisher_id=p.id) " +
                            "LEFT JOIN author a ON(b.author_id=a.id) " +
                            "WHERE (LOWER("+param+") LIKE(?)) " +
                            "ORDER BY a.fio;",
                    resSet -> buildBook(resSet),
                    prepst -> prepst.setString(1, "%"+searching.toLowerCase()+"%"));
        }
        return books;
    }
    public List<Book> getAllBooks() {
        if (books == null || books.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            books = helper.execute("SELECT a.fio as \"author\", b.image as \"image\", " +
                            "a.id as \"id\", a.birthday as \"birthday\", b.page_count as \"pages\"," +
                            " b.publish_year as \"year\",p.name as \"name\",b.name as \"bookName\"," +
                            " b.isbn as \"isbn\", g.id as \"genreId\", b.descr as \"descr\", b.rating as \"rating\"" +
                            " FROM book b " +
                            "LEFT JOIN genre g ON(b.genre_id = g.id) " +
                            "LEFT JOIN publisher p ON(b.publisher_id=p.id) " +
                            "LEFT JOIN author a ON(b.author_id=a.id) " +
                            "ORDER BY a.fio;",
                    resSet -> buildBook(resSet));
        }
        return books;
    }

    private Book buildBook(ResultSet resSet) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Book(
                new Author(resSet.getString("author"),
                        Integer.parseInt(resSet.getString("id")),
                        LocalDate.parse(resSet.getString("birthday"), formatter)),
                Integer.parseInt(resSet.getString("pages")),
                Year.parse(resSet.getString("year")),
                resSet.getString("name"),
                resSet.getString("bookName"),
                resSet.getString("isbn"),
                new Genre(Long.parseLong(resSet.getString("genreId")), resSet.getString("name")),
                resSet.getString("descr"),
                Integer.parseInt(resSet.getString("rating")),
                resSet.getBytes("image"));
    }
}
