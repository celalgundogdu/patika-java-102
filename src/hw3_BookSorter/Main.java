package hw3_BookSorter;

import java.util.*;

public class Main {

    static void print(TreeSet<Book> books){
        for(Book book : books){
            System.out.printf("Kitap: %-30s Sayfa: %-5d\n", book.getName(), book.getPageNumber());
        }
    }

    public static void main(String[] args) {

        TreeSet<Book> booksByName = new TreeSet<>();
        booksByName.add(new Book("Clean Architecture",  432,"Robert C. Martin", "2010-05-15"));
        booksByName.add(new Book("Introduction to Algorithms", 300, "Thomas H. Cormen", "2013-09-25"));
        booksByName.add(new Book("The Pragmatic Programmer", 352, "David Thomas", "2010-07-10"));
        booksByName.add(new Book("Clean Code", 464,"Robert C. Martin", "2012-05-20"));
        booksByName.add(new Book("Design Patterns", 250,"Erich Gamma", "2019-09-15"));

        print(booksByName);
        System.out.println();

        TreeSet<Book> bookByPage = new TreeSet<>(new PageComparator());
        bookByPage.addAll(booksByName);
        print(bookByPage);

    }

}
