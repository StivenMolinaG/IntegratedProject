package com.IntegratedProjectSpring.IntegratedProjectApplication;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DentistTest {

    private DentistService dentistService;

    @Autowired
    public DentistTest(DentistService dentistService){
        this.dentistService = dentistService;
    }
    @Test
    public void testCreateDentist() {
        Dentist dentist = new Dentist();

        dentist.setId(1);
        dentist.setName("Juan Esteban");
        dentist.setLastName("Restrepo Uribe");
        dentist.setEnrollment("12345");

        dentistService.create(dentist);

        Dentist dentistResponse = dentistService.search(1);

        System.out.println(dentistResponse);
        assertNotNull(dentistResponse);
    }

    @Test
    public void testSearchDentist(){
        Dentist dentist = new Dentist();

        dentist.setId(1);
        dentist.setName("Juan Esteban");
        dentist.setLastName("Restrepo Uribe");
        dentist.setEnrollment("12345");

        dentistService.create(dentist);

        Dentist dentistResponse = dentistService.search(1);

        System.out.println(dentistResponse);
        assertNotNull(dentistResponse);
    }

}
