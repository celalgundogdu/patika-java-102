package hw8_BookList;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Clean Architecture",  432,"Robert C. Martin", LocalDate.of(2010, 3,20)));
        bookList.add(new Book("Introduction to Algorithms", 300, "Thomas H. Cormen", LocalDate.of(2000, 5,20)));
        bookList.add(new Book("The Pragmatic Programmer", 352, "David Thomas", LocalDate.of(2010, 1,25)));
        bookList.add(new Book("Clean Code", 464,"Robert C. Martin", LocalDate.of(2005, 3,10)));
        bookList.add(new Book("System Design Interview ", 90,"Alex Xu", LocalDate.of(2010, 7,17)));
        bookList.add(new Book("Cracking the Coding Interview", 450,"Gayle L. McDowell", LocalDate.of(2013, 11,27)));
        bookList.add(new Book("Designing Data-Intensive Applications", 95,"Marin Kleppmann", LocalDate.of(2010, 7,17)));
        bookList.add(new Book("Ace the Data Science Interview", 420,"Kevin Huo", LocalDate.of(2003, 5,2)));
        bookList.add(new Book("R for Data Science", 50,"Hadley Wickham", LocalDate.of(2007, 6,11)));
        bookList.add(new Book("Python for Data Analysis", 93,"Wes McKinney", LocalDate.of(2004, 12,19)));

        BookManager bookManager = new BookManager();

        Map<String, String> bookMap = bookManager.convertToMap(bookList);
        bookMap.forEach((key, value) -> System.out.println(key + " --- " + value));
        System.out.println();
        Optional<List<Book>> filteredBooks = bookManager.getBooksMoreThanOneHundredPages(bookList);
        filteredBooks.ifPresent(
                list -> list.stream().
                        sorted(Comparator.comparingInt(Book::getPageNumber)).
                        forEach(book -> System.out.println(book.getName() + " --- " + book.getPageNumber()))
        );

    }

}
