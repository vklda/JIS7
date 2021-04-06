package homework.exeptions.demoDataBase;
//********Checked********* Хоть это мы не проходили сделално хорошо, молодец
import homework.exeptions.demoDataBase.exceptions.ItemNotFoundException;

import java.util.List;

public interface Repository<Book> {

    List<Book> findAll();

    Book findById(String id) throws ItemNotFoundException;

    void save(Book item);

    void delete(String id) throws ItemNotFoundException;
}
