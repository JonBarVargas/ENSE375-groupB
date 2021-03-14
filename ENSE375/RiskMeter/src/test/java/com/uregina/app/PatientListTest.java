//Karlee Fidek
package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for PatientList.
 */
public class PatientListTest {
    private PatientList patientList;
    
    @Before
    public void setUp(){
         patientList = new PatientList();
    }
    
    @Test
    public void newPatientListEmpty_True() {
        assertEquals(patientList.getNumberofPatients(), 0);
    }

   @Test
   public void addPatient_ValidPatient_True(){
        Patient patient = createPatient();
       
        assertTrue(patientList.addPatient(patient));
    }

    @Test
    public void addPatient_Null_False(){
         Patient patient = null;
         assertFalse(patientList.addPatient(patient));
     }

     @Test
     public void deletePatient_ValidPatient_True(){
        Patient patient = null;
        patient = createPatient();
        patientList.addPatient(patient);
         
        assertTrue(patientList.deletePatient(0));
     }

     @Test
     public void deletePatient_OutOfBounds_False(){
         assertFalse(patientList.deletePatient(0));
     }

     @Test
     public void getPatient_Valid(){
        Patient patient = createPatient();
        patientList.addPatient(patient);

        assertEquals(patientList.getPatient("123123120"), patient);
     }

     @Test
     public void getPatient_Null(){
        Patient patient = patientList.getPatient("123123120");
        assertTrue(patient == null);
     }
    
    private Patient createPatient() {
       try{
            Patient patient = new Patient("Joe", "123123120", 33, new PostalCode("K1T-5X2"));
            return patient;
       }
       catch (Exception e){
          System.out.println("error making patient");
       }
    }
}
