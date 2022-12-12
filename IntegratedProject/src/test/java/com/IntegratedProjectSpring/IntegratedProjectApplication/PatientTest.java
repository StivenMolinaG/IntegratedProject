package com.IntegratedProjectSpring.IntegratedProjectApplication;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientTest {

    private PatientService patientService;

    @Autowired
    public PatientTest(PatientService patientService) {
        this.patientService = patientService;
    }

    @Test
    public void testCreatePatient() {
        Address address = new Address();
        address.setStreet("Carrera 30");
        address.setProvince("Antioquia");
        address.setLocation("Envigado");
        address.setNumber("40");
        address.setId(12345678);

        Patient patient = new Patient();

        patient.setId(3);
        patient.setDNI(12344353L);
        patient.setDateOut(new Date());
        patient.setName("Stiven");
        patient.setLastName("Molina");
        patient.setAddressReference(address);

        patientService.create(patient);

        Patient patient1 = patientService.search(3);

        System.out.println(patient1);
        assertNotNull(patient1);
    }
}
