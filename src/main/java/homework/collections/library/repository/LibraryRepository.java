package homework.collections.library.repository;

import java.util.Map;

public interface LibraryRepository<Book> {
    void addBook(Book book);

    void removeBook(Book book);

    Book findByName(String bookName);

    Map<Book, Integer> findAllBooksByAuthor(String author);
}
