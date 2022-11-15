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
        Dentist dentist = new Dentist();
        preparedStatement = conn.prepareStatement("SELECT * FROM DENTIST");
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            dentist.setId(result.getInt(1));
            dentist.setName(result.getString(2));
            dentist.setLastName(result.getString(3));
            dentist.setEnrollment(result.getString(4));

            dentistList.add(dentist);
        }
        preparedStatement.close();
        conn.close();
        return dentistList;
    }

    @Override
    public boolean update(Dentist dentist) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}