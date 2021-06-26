package homework.jdbc.service;

import homework.jdbc.dbconfig.PostgresConnector;
import homework.jdbc.model.Address;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static homework.jdbc.App.log;

public class AddressServiceImpl implements AddressService {
    @Override
    public Address create(String city, Integer home, Integer appartment) throws SQLException {
        var sql = "INSERT INTO \"address\" (city, home, appartment) values (?, ?, ?);";
        var address = new Address(city, home, appartment);
        insertRowToDataBase(address, sql);
        var id = getLastId();
        address.setId(id);
        return address;
    }

    @Override
    public Collection<Address> findAll() throws SQLException {
        var addressList = new ArrayList<Address>();
        var connection = getConnection();
        var statement = connection.createStatement();
        var sql = "SELECT * FROM \"address\";";
        var resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            var build = buildAddress(resultSet);
            addressList.add(build);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return addressList;
    }

    @Override
    public void update(Address address) throws SQLException {
        String sql = "UPDATE \"user\" SET city = ?, home = ?, appartment = ? WHERE id = " + address.getId();
        insertRowToDataBase(address, sql);
    }

    @Override
    public Address getById(Integer id) throws SQLException {
        var sql = "SELECT id, city, home, appartment FROM \"address\" where id = " + id;
        var connection = getConnection();
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return buildAddress(resultSet);
        }
        statement.close();
        connection.close();
        return new Address();
    }


    @Override
    public void delete(Address address) throws SQLException {
        var connection = getConnection();
        var sql = "DELETE FROM \"address\" WHERE id = " + address.getId();
        var statement = connection.createStatement();
        statement.execute(sql);
        log.info(address + " has been deleted successfully");
        statement.close();
        connection.close();
    }

    private Address buildAddress(java.sql.ResultSet resultSet) throws SQLException {
        return Address.builder()
                .id(resultSet.getInt(1))
                .city(resultSet.getString(2))
                .home(resultSet.getInt(3))
                .appartment(resultSet.getInt(4))
                .build();
    }

    private Connection getConnection() throws SQLException {
        return PostgresConnector.getConnection();
    }

    private int getLastId() throws SQLException {
        var sql = "SELECT MAX(id) FROM \"address\"";
        var connection = getConnection();
        var statement = connection.createStatement();
        var id = 0;
        var result = statement.executeQuery(sql);
        if (result.next()) {
            id = result.getInt(1);
        }
        statement.close();
        connection.close();
        return id;
    }

    private void insertRowToDataBase(Address address, String sql) throws SQLException {
        var connection = getConnection();
        var statement = connection.prepareStatement(sql);
        statement.setString(1, address.getCity());
        statement.setInt(2, address.getHome());
        statement.setInt(3, address.getAppartment());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            log.info("address has been updated/created successfully");
        }
        statement.close();
        connection.close();
    }
}
