package com.IntegratedProjectSpring.IntegratedProjectApplication.daos;

import com.IntegratedProjectSpring.IntegratedProjectApplication.db.H2DB;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDaoH2 implements IDao<Patient>{
    private final static Logger LOGGER = LogManager.getLogger();
    private final Connection conn = H2DB.getConecction();
    private final AddressDaoH2 addressDaoH2;

    public PatientDaoH2(AddressDaoH2 addressDaoH2) {
        this.addressDaoH2 = addressDaoH2;
    }

    @Override
    public Patient create(Patient patient) throws SQLException {
        PreparedStatement preparedStatement;

        Address address = addressDaoH2.create(patient.getAddress());
        patient.getAddress().setId(address.getId());
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO PATIENT (id, name, lastName, address, DNI, dateOut) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,patient.getId());
            preparedStatement.setString(2,patient.getName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setInt(4, patient.getAddress().getId());
            preparedStatement.setString(5, patient.getDNI());
            preparedStatement.setDate(6, Util.utilDateToSqlDate(patient.getDateOut()));

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
            patient = createPatientObject(resultSet);
        }
        return patient;
    }

    @Override
    public List<Patient> searchAll() throws SQLException {
        List<Patient> patientList = new ArrayList<Patient>();
        PreparedStatement preparedStatement;
        Patient patient = new Patient();
        preparedStatement = conn.prepareStatement("SELECT * FROM PATIENT");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            patientList.add(createPatientObject(resultSet));
        }
        return patientList;
    }

    @Override
    public Patient update(Patient patient) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private Patient createPatientObject(ResultSet resultSet) throws SQLException {
        Integer idPatient = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String lastName = resultSet.getString("lastName");
        String DNI = resultSet.getString("DNI");
        Date dateOut = resultSet.getDate("dateOut");
        Address address = addressDaoH2.search(resultSet.getInt("address"));
        return new Patient(idPatient, name, lastName, address, DNI, dateOut);
    }
}
