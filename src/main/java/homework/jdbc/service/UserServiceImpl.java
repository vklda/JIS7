package homework.jdbc.service;

import homework.jdbc.dbconfig.PostgresConnector;
import homework.jdbc.model.Status;
import homework.jdbc.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static homework.jdbc.App.log;

public class UserServiceImpl implements UserService {

    @Override
    public User create(String firstName, String lastName, String username, Status status, String email) throws SQLException {
        var connection = PostgresConnector.getConnection();
        var sql = "INSERT INTO \"user\" (first_name, last_name, username, status, email) VALUES (?, ?, ?, ?, ?)";
        var user = new User(0, firstName, lastName, username, status, email);
        executeUpdate(user, connection, sql);
        var id = getLastId(connection);
        user.setId(id);
        connection.close();
        return user;
    }

    @Override
    public Collection<User> findAll() throws SQLException {
        var userList = new ArrayList<User>();
        var statement = PostgresConnector.getStatement();
        var sql = "SELECT * FROM \"user\";";
        var resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            var user = buildUser(resultSet);
            userList.add(user);
        }
        resultSet.close();
        statement.close();
        return userList;
    }

    @Override
    public User getById(Integer id) throws SQLException {
        var sql = "SELECT id, first_name, last_name, username, status, email FROM \"user\" where id = " + id;
        var statement = PostgresConnector.getStatement();
        var resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return buildUser(resultSet);
        }
        return new User();
    }

    @Override
    public Collection<User> getByFirstAndLastChars(String first, String last) throws SQLException {
        var userList = new ArrayList<User>();
        var sql = "SELECT id, first_name, last_name, username, status, email FROM \"user\" where first_name LIKE ?";
        var statement = PostgresConnector.getConnection().prepareStatement(sql);
        statement.setString(1, first + "%" + last);
        var resultSet = statement.executeQuery();
        while (resultSet.next()) {
            var user = buildUser(resultSet);
            userList.add(user);
        }
        statement.close();
        return userList;
    }

    @Override
    public void delete(User user) throws SQLException {
        var sql = "DELETE FROM \"user\" WHERE id = " + user.getId();
        var statement = PostgresConnector.getStatement();
        statement.execute(sql);
        log.info("user " + user.getUsername() + " has been deleted successfully");
        statement.close();
    }

    @Override
    public void update(User user) throws SQLException {
        var connection = PostgresConnector.getConnection();
        String sql = "UPDATE \"user\" SET first_name = ?, last_name = ?, username = ?, status = ?, email = ? WHERE id = " + user.getId();
        executeUpdate(user, connection, sql);
        connection.close();
    }

    private int getLastId(Connection connection) throws SQLException {
        var sql = "SELECT MAX(id) FROM \"user\"";
        var statement = connection.prepareStatement(sql);
        var id = 0;
        var result = statement.executeQuery();
        if (result.next()) {
            id = result.getInt(1);
        }
        statement.close();
        return id;
    }

    private User buildUser(ResultSet resultSet) throws SQLException {
        var user = new User();
        user.setId(resultSet.getInt(1));
        user.setFirstName(resultSet.getString(2));
        user.setLastName(resultSet.getString(3));
        user.setUsername(resultSet.getString(4));
        user.setStatus(Status.valueOf(resultSet.getString(5)));
        user.setEmail(resultSet.getString(6));
        return user;
    }

    private void executeUpdate(User user, Connection connection, String sql) throws SQLException {
        var statement = connection.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getStatus().name());
        statement.setString(5, user.getEmail());
        int i = statement.executeUpdate();
        if (i > 0) {
            log.info("user has been updated/created successfully");
        }
    }
}
