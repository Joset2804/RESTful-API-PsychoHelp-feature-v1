package com.examples.mockitoJUnit;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.patient.domain.model.entity.State;
import com.psycho.psychohelp.patient.domain.persistence.PatientRepository;
import com.psycho.psychohelp.patient.service.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.validation.Validator;
import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class PatientUnitTest {

    @Mock
    Validator validator;

    @Mock
    Patient request;

    @InjectMocks
    PatientServiceImpl patientService;

    @Mock
    PatientRepository patientRepository;

    @Before
    public void setUp() {
        initMocks(this);
        Date date = new Date(1980, 12, 3);
        request = new Patient(1L, "jose", "ivan", "strtg@gmail.com", "qweerwrrtyy", "987654321", date, "qweerwr", "qweerwr", State.SINGLE);
    }

    ;

    @Test
    public void getAllTest() {
        Mockito.when(patientRepository.findAll()).thenReturn(Arrays.asList(request));
        assertNotNull(patientService.getAll());
    }

    @Test
    public void createPatientTest() {
        Mockito.when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(request);
        assertNotNull(patientService.create(new Patient()));
    }

    @Test
    public void getByIdPatientTest() {
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(new Patient()));
        assertNotNull(patientService.getById(1L));
    }

    @Test
    public void getByEmailPatientTest() {
        Mockito.when(patientRepository.findByEmail("strtg@gmail.com")).thenReturn(new Patient());
        assertNotNull(patientService.getByEmail("strtg@gmail.com"));
    }

    @Test
    public void deletePatientTest(){
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(new Patient()));
        assertNotNull(patientService.delete(1L));
    }

//    @Test
//    public void updatePatientTest(){
//        Mockito.when(patientRepository.save(Mockito.any())).thenReturn(request);
//        patientService.update(1L, new Patient());
//    }
}
