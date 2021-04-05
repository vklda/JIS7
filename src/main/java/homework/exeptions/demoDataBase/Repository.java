package homework.exeptions.demoDataBase;

import homework.exeptions.demoDataBase.exceptions.ItemNotFoundException;

import java.util.List;

public interface Repository<Book> {

    List<Book> findAll();

    Book findById(String id) throws ItemNotFoundException;

    void save(Book item);

    void delete(String id) throws ItemNotFoundException;
}
