package com.IntegratedProjectSpring.IntegratedProject.daos;

import com.IntegratedProjectSpring.IntegratedProject.db.H2DB;
import com.IntegratedProjectSpring.IntegratedProject.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PatientDaoH2 implements IDao<Patient>{
    private final static Logger LOGGER = LogManager.getLogger();
    private final Connection conn = H2DB.getConecction();

    @Override
    public Patient create(Patient patient) throws SQLException {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO PATIENT (name, lastName, address, DNI, dateOut) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getDNI());
            preparedStatement.setDate(5, patient.getDateOut());

            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public Patient search(int id) throws SQLException {
        PreparedStatement preparedStatement;
        Patient patient = new Patient();
        preparedStatement = conn.prepareStatement("SELECT * FROM PATIENT WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            patient.setDNI(resultSet.getString(5));
            patient.setName(resultSet.getString(2));
            patient.setLastName(resultSet.getString(3));
            patient.setAddress(resultSet.getString(4));
            patient.setDateOut(resultSet.getDate(6));
        }
        preparedStatement.close();
        conn.close();
        return patient;
    }

    @Override
    public List<Patient> searchAll(){
        return null;
    }

    @Override
    public boolean update(Patient patient) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
