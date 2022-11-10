package service;

import daos.IDao;
import entity.Paciente;

import java.sql.SQLException;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public void setPacienteDao(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente crear(Paciente paciente) throws SQLException {
        return this.pacienteDao.crear(paciente);
    }

    public Paciente buscar(int id) throws SQLException {
        return this.pacienteDao.buscar(id);
    }
}
