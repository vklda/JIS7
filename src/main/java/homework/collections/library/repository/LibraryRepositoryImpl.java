package homework.collections.library.repository;

import homework.collections.library.exceptions.BookNotFoundException;
import homework.collections.library.model.Book;
import homework.collections.library.repository.LibraryRepository;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepositoryImpl implements LibraryRepository<Book> {
    private static final Map<Book, Integer> library = new HashMap<>(); //book and amount
    private static final Integer ONE = 1;

    @Override
    public void addBook(Book book) {
        if (library.containsKey(book)) {
            Integer amountBooks = library.get(book) + 1;
            library.put(book, amountBooks);
            return;
        }
        library.put(book, ONE);
    }

    @Override
    public void removeBook(Book book) {
        library.remove(book);
    }

    @Override
    public Book findByName(String bookName) {
        for (Map.Entry<Book, Integer> book : library.entrySet()) {
            if (isMapExistBook(bookName, book)) {
                return book.getKey();
            }
        }
        throw new BookNotFoundException("Book with bookName: " + bookName + " not found");
    }

    @Override
    public Map<Book, Integer> findAllBooksByAuthor(String author) {
        Map<Book, Integer> books = new HashMap<>();
        for (Map.Entry<Book, Integer> book : library.entrySet()) {
            if (isMapExistBooksWithAuthor(author, book)) {
                books.put(book.getKey(), book.getValue());
            }
        }
        if (books.size() > 0) {
            return books;
        }
        throw new BookNotFoundException("Books with author: " + author + " not found");
    }

    private boolean isMapExistBook(String bookName, Map.Entry<Book, Integer> book) {
        return book.getKey().getBookName().equals(bookName);
    }

    private boolean isMapExistBooksWithAuthor(String author, Map.Entry<Book, Integer> book) {
        return book.getKey().getAuthor().equals(author);
    }


}
