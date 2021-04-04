// Anupras Burokas
package com.uregina.app;
import com.uregina.exception.*;


import static org.junit.Assert.*;

import org.junit.Test;



public class PatientTest {

    @Test
    public void constructPatient_Valid_True() {
        try {
            Patient patient = new Patient("Joe", "123123123", 33, new PostalCode("K1T-5X2"));
        } catch (Exception e) {
            fail();
        }
    }


    @Test(expected = InvalidNameException.class)
    public void constructPatient_InvalidName_Throws() throws Exception {

        Patient patient = new Patient("Joe34", "123123123", 33, new PostalCode("K1T-5X2"));
    }

    @Test(expected = InvalidIDException.class)
    public void constructPatient_InvalidID_Throws() throws Exception {

        Patient patient = new Patient("Joe", "000000000", 33, new PostalCode("K1T-5X2"));
    }

    @Test(expected = InvalidAgeException.class)
    public void constructPatient_InvalidAge_Throws() throws Exception {

        Patient patient = new Patient("Joe", "123123121", -44, new PostalCode("K1T-5X2"));
    }


    @Test(expected = InvalidPostalCodeException.class)
    public void constructPatient_InvalidPostalCode_Throws() throws Exception {

        Patient patient = new Patient("Joe", "123123121", 44, new PostalCode("K1Z 5X2"));
    }

    @Test
    public void getName_Valid_True() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        assertTrue(patient.getName().equals("Joe"));
    }

    @Test
    public void getID_Valid_True() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        assertTrue(patient.getID().equals("123123121"));
    }

    @Test
    public void getAge() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        assertTrue(patient.getAge() == 33);
    }


    @Test
    public void setAge_Valid_True() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        patient.setAge(44);
        assertEquals(patient.getAge(),44);
    }

    @Test
    public void setAge_Invalid_False() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        assertFalse(patient.setAge(-5));
    }


    @Test
    public void setPostalCode_Valid_True() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        PostalCode pc = new PostalCode("K1B-3X2");
        patient.setPostalCode(pc);
        assertEquals(patient.getPostalCode(),pc);
    }

    @Test(expected = InvalidPostalCodeException.class)
    public void setPostalCode_Invalid_True() throws Exception{
        Patient patient = new Patient("Joe", "123123121", 33, new PostalCode("K1T-5X2"));
        patient.setPostalCode(new PostalCode("K1Z-3X2"));
    }
  
}
