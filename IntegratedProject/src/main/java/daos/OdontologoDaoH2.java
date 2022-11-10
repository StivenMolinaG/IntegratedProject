package daos;

import db.H2DB;
import entity.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo>{

    private static final Logger LOGGER = LogManager.getLogger();

    private final Connection conn = H2DB.getConecction();
    @Override
    public Odontologo crear(Odontologo odontologo) {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO DENTIST (id, nombre, apellido, matricula) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.setString(4,odontologo.getMatricula());

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
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }

    @Override
    public boolean actualizar(Odontologo odontologo) {
        return false;
    }

    @Override
    public boolean borrar(int id) {
        return false;
    }
}
