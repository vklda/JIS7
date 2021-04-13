package homework.exeptions.demoDataBase;

import homework.exeptions.demoDataBase.exceptions.ItemNotFoundException;
import homework.exeptions.userValidateServise.User;
import homework.exeptions.userValidateServise.UserValidateService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookRepositoryTest {
    private static final Logger logger = Logger.getLogger(BookRepositoryTest.class);
    Book book;
    BookRepository bookRepository;


    @BeforeEach
    public void setup() {
        bookRepository = new BookRepository();
        book = new Book("1", "1984", "Джордж Оруэлл", 320);
        BookRepository.dataBase.put(book.getId(), book);

        book = new Book("2", "Метро 2033", "Дмитрий Глуховский", 384);
        BookRepository.dataBase.put(book.getId(), book);

        book = new Book("3", "Кэрри", "Стивен Кинг", 320);
        BookRepository.dataBase.put(book.getId(), book);
    }

    @Test
    public void saveNewBook() {
        book = new Book("4", "Философия Java", "Брюс Эккель", 1170);
        bookRepository.save(book);
        Assert.assertEquals(4, bookRepository.findAll().size());
    }

    @Test
    public void getBookWithWrongId() {
        try {
            bookRepository.findById("6");
        } catch (ItemNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void getBookWithRealId() {
        try {
            logger.info(bookRepository.findById("3"));
        } catch (ItemNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void tryRemoveBookWithWrongId() {
        try {
            bookRepository.delete("6");
        } catch (ItemNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void removesBookWithRealId() {
        try {
            bookRepository.delete("3");
            Assert.assertEquals(2, bookRepository.findAll().size());
        } catch (ItemNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void findAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        for (Book books : bookList) {
            logger.info(books.toString());
        }
    }


}