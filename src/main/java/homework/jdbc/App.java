package homework.jdbc;

import homework.jdbc.model.Status;
import homework.jdbc.service.UserServiceImpl;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) throws SQLException {
        var userService = new UserServiceImpl();

        userService.create("Влад", "Коляда", "vklda", Status.VIP, "vklda@mail.ru");
        log.info(userService.findAll().toString());
        var userList = new ArrayList<>(userService.findAll());
        userList.get(0).setFirstName("Владислав");
        userService.update(userList.get(0));
        log.info(userList.get(0));
        log.info(userService.getById(1));
        log.info(userService.getByFirstAndLastChars("A", "y"));
        userService.delete(userList.get(0));
        log.info(userService.findAll());
    }
}
