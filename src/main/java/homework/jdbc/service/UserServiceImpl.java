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
    AddressService addressService = new AddressServiceImpl();

    @Override
    public User create(String firstName, String lastName, String username, Status status, String email, Integer addressId) throws SQLException {
        var sql = "INSERT INTO \"user\" (first_name, last_name, username, status, email, address_id) VALUES (?, ?, ?, ?, ?, ?)";
        var user = new User(firstName, lastName, username, status, email);
        var address = addressService.getById(addressId);
        user.setAddress(address);
        insertRowToDataBase(user, sql);
        var id = getLastId();
        user.setId(id);
        return user;
    }

    @Override
    public Collection<User> findAll() throws SQLException {
        var userList = new ArrayList<User>();
        var connection = getConnection();
        var statement = connection.createStatement();
        var sql = "SELECT * FROM \"user\";";
        var resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            var user = buildUser(resultSet);
            userList.add(user);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return userList;
    }

    @Override
    public User getById(Integer id) throws SQLException {
        var sql = "SELECT * FROM \"user\" where id = " + id;
        var connection = getConnection();
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return buildUser(resultSet);
        }
        statement.close();
        connection.close();
        return new User();
    }

    @Override
    public Collection<User> getByFirstAndLastChars(String first, String last) throws SQLException {
        var userList = new ArrayList<User>();
        var sql = "SELECT * FROM \"user\" where first_name LIKE ?";
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
        var connection = getConnection();
        var sql = "DELETE FROM \"user\" WHERE id = " + user.getId();
        var statement = connection.createStatement();
        statement.execute(sql);
        log.info("user " + user.getUsername() + " has been deleted successfully");
        statement.close();
        connection.close();
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE \"user\" SET first_name = ?, last_name = ?, username = ?, status = ?, email = ?, address_id = ? WHERE id = " + user.getId();
        insertRowToDataBase(user, sql);
    }

    private Connection getConnection() throws SQLException {
        return PostgresConnector.getConnection();
    }

    private int getLastId() throws SQLException {
        var sql = "SELECT MAX(id) FROM \"user\"";
        var connection = getConnection();
        var statement = connection.prepareStatement(sql);
        var id = 0;
        var result = statement.executeQuery();
        if (result.next()) {
            id = result.getInt(1);
        }
        statement.close();
        connection.close();
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
        user.setAddress(addressService.getById(resultSet.getInt(7)));
        return user;
    }

    private void insertRowToDataBase(User user, String sql) throws SQLException {
        var connection = getConnection();
        var statement = connection.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getStatus().name());
        statement.setString(5, user.getEmail());
        statement.setInt(6, user.getAddress().getId());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            log.info("user has been updated/created successfully");
        }
        statement.close();
        connection.close();
    }
}
