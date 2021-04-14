package Beans;

import java.awt.*;
import java.time.LocalDate;

public class Book {
    private byte[] content;
    private Author author;
    private int pages;
    private LocalDate publishDate;
    private String publisher;
    private Image image;
    private String name;
    private String isbn;
    private Genre genre;
    private String desc;
    private int rating;

    public Book(String name, String isbn, String genre, String description, int page_count, int rating) {
        this.name = name;
        this.genre = new Genre(genre);
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
