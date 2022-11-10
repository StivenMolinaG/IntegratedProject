import daos.OdontologoDaoH2;
import daos.PacienteDaoH2;
import db.H2DB;
import entity.Odontologo;
import entity.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OdontologoService;
import service.PacienteService;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws SQLException {

        H2DB.createTables();
        Odontologo odontologo = new Odontologo(1,"Juan", "Restrepo", "54778");
        Odontologo odontologo2 = new Odontologo(2,"Ana", "Betancur", "3265");
        Odontologo odontologo3 = new Odontologo(3,"Carolina", "Giraldo", "23421");
        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoDao(new OdontologoDaoH2());
        odontologoService.crear(odontologo);
        odontologoService.crear(odontologo2);
        odontologoService.crear(odontologo3);

        Date date = new Date(116,5,5);
        Paciente paciente = new Paciente("Catalina", "Molina", "Carrera 30", "120893", date);
        Paciente paciente1 = new Paciente("Stiven", "Giraldo", "Carrera 40", "23423", date);
        Paciente paciente2 = new Paciente("Norberto", "Canario", "Carrera 20", "5467657", date);
        PacienteService pacienteService = new PacienteService();

        pacienteService.setPacienteDao(new PacienteDaoH2());
        pacienteService.crear(paciente);
        pacienteService.crear(paciente1);
        pacienteService.crear(paciente2);

        /* Buscando Paciente */
        pacienteService.buscar(3);

        LOGGER.info("Se creo un odontologo y un Paciente con exito");
    }
}