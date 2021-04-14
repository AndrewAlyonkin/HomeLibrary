package Beans;

import java.time.LocalDate;

public class Genre {
   private String name;

    public Genre(String genre) {
        this.name = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
