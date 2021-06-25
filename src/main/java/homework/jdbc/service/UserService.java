package homework.jdbc.service;

import homework.jdbc.model.Status;
import homework.jdbc.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService {

    User create(String firstName, String lastName, String username, Status status, String email, Integer addressId) throws SQLException;

    Collection<User> findAll() throws SQLException;

    void update(User user) throws SQLException;

    User getById(Integer id) throws SQLException;

    Collection<User> getByFirstAndLastChars(String first, String last) throws SQLException;

    void delete(User user) throws SQLException;
}
