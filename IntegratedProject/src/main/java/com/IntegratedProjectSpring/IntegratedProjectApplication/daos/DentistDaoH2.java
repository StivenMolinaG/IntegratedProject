package com.IntegratedProjectSpring.IntegratedProjectApplication.daos;

import com.IntegratedProjectSpring.IntegratedProjectApplication.db.H2DB;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist>{

    private static final Logger LOGGER = LogManager.getLogger();

    private final Connection conn = H2DB.getConecction();
    @Override
    public Dentist create(Dentist dentist) {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO DENTIST (id, name, lastName, enrollment) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, dentist.getId());
            preparedStatement.setString(2, dentist.getName());
            preparedStatement.setString(3, dentist.getLastName());
            preparedStatement.setString(4, dentist.getEnrollment());

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
        return dentist;
    }

    @Override
    public Dentist search(int id) throws SQLException {
        PreparedStatement preparedStatement;
        Dentist dentist = new Dentist();
        preparedStatement = conn.prepareStatement("SELECT * FROM DENTIST WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            dentist.setId(resultSet.getInt(1));
            dentist.setName(resultSet.getString(2));
            dentist.setLastName(resultSet.getString(3));
            dentist.setEnrollment(resultSet.getString(4));
        }
        preparedStatement.close();
        conn.close();
        return dentist;
    }

    @Override
    public List<Dentist> searchAll() throws SQLException {
        List<Dentist> dentistList = new ArrayList<Dentist>();
        PreparedStatement preparedStatement;
        String query = "SELECT * FROM DENTIST";
        preparedStatement = conn.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            dentistList.add(createDentistObject(result));
        }
        preparedStatement.close();
        conn.close();
        return dentistList;
    }

    @Override
    public Dentist update(Dentist dentist) throws SQLException {
        PreparedStatement preparedStatement;
        String query = "UPDATE DENTIST SET NAME= ? , LASTNAME= ? , ENROLLMENT= ? WHERE ID= ?";
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, dentist.getName());
        preparedStatement.setString(2, dentist.getLastName());
        preparedStatement.setString(3, dentist.getEnrollment());
        preparedStatement.setInt(4, dentist.getId());
        preparedStatement.execute();
        conn.close();
        return dentist;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private Dentist createDentistObject(ResultSet resultSet) throws SQLException {

        return new Dentist(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("lastName"),
                resultSet.getString("enrollment"));
    }
}