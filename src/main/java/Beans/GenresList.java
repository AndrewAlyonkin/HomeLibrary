package Beans;

import dbUtil.DbHelper;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenresList {
    private DbHelper helper = new DbHelper();
    private List<Genre> genres;

    public List<Genre> getGenres() {
        if (genres != null && !genres.isEmpty()) return genres;

        return helper.execute("SELECT * FROM genre",
                resSet -> new Genre(
                        Long.valueOf(resSet.getString("id")),
                        resSet.getString("name"))

        );
    }
}
