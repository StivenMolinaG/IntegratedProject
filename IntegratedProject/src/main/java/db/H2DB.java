package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DB {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS DENTIST (id INT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), matricula VARCHAR(255))";
    private static final String CREATE_TABLE_PACIENTE = "CREATE TABLE IF NOT EXISTS PATIENT (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), " +
            "domicilio VARCHAR(255)," +
            "DNI varchar(255)," +
            "fechaAlta Date)";
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
