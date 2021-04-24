package homework.collections.library;


import homework.collections.library.model.Book;
import homework.collections.library.repository.LibraryRepository;
import homework.collections.library.repository.LibraryRepositoryImpl;
import homework.collections.library.service.LibraryService;

public class AppLibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Leo Tolstoy", "War and Peace");
        Book book2 = new Book("Leo Tolstoy", "Anna Karenina");
        Book book3 = new Book("Bruce Eckel", "Thinking in Java");
        LibraryRepository<Book> libraryRepository = new LibraryRepositoryImpl();
        LibraryService libraryService = new LibraryService(libraryRepository);
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);
        libraryService.addBook(book1);

        System.out.println(libraryService.findByName("War and Peace"));
        System.out.println(libraryService.findAllBooksByAuthor("Leo Tolstoy"));
        libraryService.removeBook(book1);
        System.out.println(libraryService.findAllBooksByAuthor("Leo Tolstoy"));
    }
}
