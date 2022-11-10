package service;

import daos.IDao;
import entity.Odontologo;

import java.sql.SQLException;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;

    public void setOdontologoDao(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo crear(Odontologo odontologo) throws SQLException {
        return this.odontologoDao.crear(odontologo);
    }
}
