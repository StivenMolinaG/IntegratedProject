package com.IntegratedProjectSpring.IntegratedProjectApplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DB {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS DENTIST (id INT PRIMARY KEY, name VARCHAR(255), lastName VARCHAR(255), enrollment VARCHAR(255))";
    private static final String CREATE_TABLE_PACIENTE = "CREATE TABLE IF NOT EXISTS PATIENT (id INT PRIMARY KEY, name VARCHAR(255), lastName VARCHAR(255), " +
            "address int," +
            "DNI varchar(255)," +
            "dateOut Date)";
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/integratedProject";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConecction(){
        Connection connection;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void createTables(){
        try{
            Connection connection = getConecction();
            connection.createStatement().execute(CREATE_TABLE);
            connection.createStatement().execute(CREATE_TABLE_PACIENTE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
