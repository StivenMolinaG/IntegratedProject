package com.IntegratedProjectSpring.IntegratedProjectApplication.daos;

import com.IntegratedProjectSpring.IntegratedProjectApplication.db.H2DB;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoH2 implements IDao<Address>{
    private static final Logger LOGGER = LogManager.getLogger();

    private final Connection conn = H2DB.getConecction();
    @Override
    public Address create(Address address) throws SQLException {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO ADDRESS (id, street, number, location, province) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getNumber());
            preparedStatement.setString(4, address.getLocation());
            preparedStatement.setString(5, address.getProvince());

            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                LOGGER.error("Error al ejecutar el insert con la excepción: "+ ex);
            }
            throw new RuntimeException(e);
        }
        return address;
    }

    @Override
    public Address search(int id) throws SQLException {
        PreparedStatement preparedStatement;
        Address address = new Address();
        preparedStatement = conn.prepareStatement("SELECT * FROM ADDRESS WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            address.setId(resultSet.getInt("id"));
            address.setStreet(resultSet.getString("street"));
            address.setNumber(resultSet.getString("number"));
            address.setLocation(resultSet.getString("location"));
            address.setProvince(resultSet.getString("province"));
        }
        preparedStatement.close();
        conn.close();
        return address;
    }

    @Override
    public List<Address> searchAll() throws SQLException {
        return null;
    }

    @Override
    public Address update(Address address) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private Address createAddresssObject(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String street = result.getString("street");
        String number = result.getString("number");
        String location = result.getString("location");
        String province = result.getString("province");
        return new Address(id, street, number, location, province);

    }
}
