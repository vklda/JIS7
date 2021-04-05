package homework.exeptions.demoDataBase;

import homework.exeptions.demoDataBase.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository implements Repository<Book> {
    static Map<String, Book> dataBase = new HashMap<>();

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        for (Map.Entry<String, Book> entry : dataBase.entrySet()) {
            bookList.add(entry.getValue());
        }
        return bookList;
    }

    @Override
    public Book findById(String id) {
        Book book = null;
        if (dataBase.containsKey(id)) {
            book = dataBase.get(id);
        } else throw new ItemNotFoundException("key " + id + " does not exist");
        return book;
    }

    @Override
    public void save(Book book) {
        dataBase.put(book.getId(), book);
    }


    @Override
    public void delete(String id) throws ItemNotFoundException {
        if (dataBase.containsKey(id)) {
            dataBase.remove(id);
        } else throw new ItemNotFoundException("key " + id + " does not exist");
    }
}
