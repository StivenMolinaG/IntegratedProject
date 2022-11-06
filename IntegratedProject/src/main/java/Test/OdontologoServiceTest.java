package Test;

import daos.OdontologoDaoH2;
import entity.Odontologo;
import org.testng.annotations.Test;
import service.OdontologoService;

import java.sql.SQLException;

import static org.testng.AssertJUnit.*;


public class OdontologoServiceTest {

    @Test
    public void crear() throws SQLException {
        Odontologo odontologo = new Odontologo(3,"Catalina", "Restrepo", "3764");
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoDao(new OdontologoDaoH2());
        Odontologo odontologoDB = odontologoService.crear(odontologo);
        assertEquals(odontologo.getId(), odontologoDB.getId());
    }
}