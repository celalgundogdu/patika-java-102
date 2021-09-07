package hw8_BookList;

import java.time.LocalDate;

public class Book {

    private String name;
    private int pageNumber;
    private String author;
    private LocalDate releaseDate;

    public Book(String name, int pageNumber, String author, LocalDate releaseDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
