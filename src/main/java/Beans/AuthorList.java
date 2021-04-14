package Beans;

import dbUtil.DbHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class AuthorList {
    private DbHelper helper = new DbHelper();
    private List<Author> authors;

    public List<Author> getAuthors() {
        if (authors!=null && !authors.isEmpty()) return authors;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return helper.execute("SELECT * FROM author ORDER BY fio", resSet -> new Author(resSet.getString("fio"),
                Integer.parseInt(resSet.getString("id")),
                LocalDate.parse(resSet.getString("birthday"), formatter)));
    }
}
