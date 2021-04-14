package Beans;

import dbUtil.DbHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookList {
    private DbHelper helper = new DbHelper();
    private List<Book> books;

    public List<Book> getAuthors() {
        if (books != null && !books.isEmpty()) return books;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return helper.execute("SELECT * FROM book b LEFT JOIN genre g ON(b.genre_id=g.id)",
                resSet -> new Book(
                        resSet.getString("b.name"),
                        resSet.getString("b.isbn"),
                        resSet.getString("g.name"),
                        resSet.getString("b.descr"),
                        Integer.parseInt(resSet.getString("page_count")),
                        Integer.parseInt(resSet.getString("rating")))
        );
    }
}
