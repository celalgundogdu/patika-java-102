package hw8_BookList;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookManager {

    public HashMap<String, String> convertToMap(ArrayList<Book> bookList){
        return bookList.stream().collect(Collectors.toMap(Book::getName, Book::getAuthor, (name, author) -> name + ", " + author, HashMap::new));
    }

    public Optional<List<Book>> getBooksMoreThanOneHundredPages(ArrayList<Book> bookList){
        List<Book> books = bookList.stream().filter(book -> book.getPageNumber() > 100).collect(Collectors.toList());
        return Optional.of(books);
    }

}
