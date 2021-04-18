package Beans;

import java.awt.*;
import java.time.LocalDate;
import java.time.Year;

public class Book {
    private byte[] content;
    private Author author;
    private int pages;
    private Year publishDate;
    private String publisher;
    private byte[] image;
    private String name;
    private String isbn;
    private Genre genre;
    private String desc;
    private int rating;

    public Book(Author author, int pages, Year publishDate,
                String publisher, String name,
                String isbn, Genre genre, String desc, int rating, byte[] image) {
        this.author = author;
        this.pages = pages;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.name = name;
        this.isbn = isbn;
        this.genre = genre;
        this.desc = desc;
        this.rating = rating;
    }

    public Book(String name, String isbn, String genre, String genreId, String description, int page_count, int rating) {
        this.name = name;
        this.genre = new Genre(Long.valueOf(genreId), genre);
        this.desc = description;
        this.pages = page_count;
        this.rating = rating;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Year getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Year publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
