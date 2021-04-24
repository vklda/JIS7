package homework.collections.library.service;

import homework.collections.library.model.Book;
import homework.collections.library.repository.LibraryRepository;

import java.util.Map;

public class LibraryService {
    private final LibraryRepository<Book> libraryRepository;

    public LibraryService(LibraryRepository<Book> libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void addBook(Book book) {
        libraryRepository.addBook(book);
    }

    public void removeBook(Book book) {
        libraryRepository.removeBook(book);
    }

    public Book findByName(String bookName) {
        return libraryRepository.findByName(bookName);
    }

    public Map<Book, Integer> findAllBooksByAuthor(String author) {
        return libraryRepository.findAllBooksByAuthor(author);
    }

}
