package daos;

import db.H2DB;
import entity.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PacienteDaoH2 implements IDao<Paciente>{
    private final static Logger LOGGER = LogManager.getLogger();
    private final Connection conn = H2DB.getConecction();

    @Override
    public Paciente crear(Paciente paciente) throws SQLException {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO PATIENT (nombre, apellido, domicilio, DNI, fechaAlta) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDNI());
            preparedStatement.setDate(5, paciente.getFechaAlta());

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
        return paciente;
    }

    @Override
    public Paciente buscar(int id) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement("SELECT * FROM PATIENT WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            LOGGER.info("El paciente con id: " + id);
            LOGGER.info("nombre: " + resultSet.getString(2) +
                    "\n Apellido " + resultSet.getString(3)
            + "\n Domicilio " + resultSet.getString(4) +
                    "\n DNI " + resultSet.getString(5));
        }
        preparedStatement.close();
        conn.close();
        return null;
    }

    @Override
    public List<Paciente> buscarTodos(){
        return null;
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        return false;
    }

    @Override
    public boolean borrar(int id) {
        return false;
    }
}
