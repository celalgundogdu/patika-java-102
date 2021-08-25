package hw3_BookSorter;

import java.time.LocalDate;

public class Book implements Comparable<Book>{

    private String name;
    private int pageNumber;
    private String author;
    private String releaseDate;

    public Book(String name, int pageNumber, String author, String releaseDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Book o1) {
        return this.getName().compareTo(o1.getName());
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
