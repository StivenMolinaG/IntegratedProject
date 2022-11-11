package com.IntegratedProjectSpring.IntegratedProject;

import com.IntegratedProjectSpring.IntegratedProject.db.H2DB;
import com.IntegratedProjectSpring.IntegratedProject.daos.DentistDaoH2;
import com.IntegratedProjectSpring.IntegratedProject.daos.PatientDaoH2;
import com.IntegratedProjectSpring.IntegratedProject.entity.Dentist;
import com.IntegratedProjectSpring.IntegratedProject.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.IntegratedProjectSpring.IntegratedProject.services.DentistService;
import com.IntegratedProjectSpring.IntegratedProject.services.PatientService;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws SQLException {

        H2DB.createTables();
        Dentist dentist = new Dentist(4,"Juan", "Restrepo", "54778");
        Dentist dentist2 = new Dentist(5,"Ana", "Betancur", "3265");
        Dentist dentist3 = new Dentist(6,"Carolina", "Giraldo", "23421");
        DentistService dentistService = new DentistService();

        dentistService.setDentistDao(new DentistDaoH2());
        dentistService.create(dentist);
        dentistService.create(dentist2);
        dentistService.create(dentist3);

        Date date = new Date(116,5,5);
        Patient patient = new Patient("Catalina", "Molina", "Carrera 30", "120893", date);
        Patient patient1 = new Patient("Stiven", "Giraldo", "Carrera 40", "23423", date);
        Patient patient2 = new Patient("Norberto", "Canario", "Carrera 20", "5467657", date);
        PatientService pacienteService = new PatientService();

        pacienteService.setPatientDao(new PatientDaoH2());
        pacienteService.create(patient);
        pacienteService.create(patient1);
        pacienteService.create(patient2);

        /* Buscando Paciente */
        pacienteService.search(3);

        LOGGER.info("Se creo un odontologo y un Paciente con exito");
    }
}