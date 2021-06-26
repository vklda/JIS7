package homework.jdbc.service;

import homework.jdbc.model.Address;

import java.sql.SQLException;
import java.util.Collection;

public interface AddressService {
    Address create(String city, Integer home, Integer appartment) throws SQLException;

    Collection<Address> findAll() throws SQLException;

    void update(Address address) throws SQLException;

    Address getById(Integer id) throws SQLException;

    void delete(Address address) throws SQLException;
}
