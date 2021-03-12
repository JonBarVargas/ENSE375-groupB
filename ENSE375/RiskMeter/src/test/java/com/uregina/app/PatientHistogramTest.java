package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for PatientHistogram.
 */
public class PatientHistogramTest {
    private PatientHistogram histo;

    @Before
    public void setUp(){
         histo = new PatientHistogram();
    }

    @Test
    public void addPatientToARegion_Valid_True() {
        assertTrue(histo.addAPatientToRegion(10, 5));
    }

    @Test
    public void addPatientToARegion_InvalidVertical_False() {
        assertFalse(histo.addAPatientToRegion(25, 5));

    }

    @Test
    public void addPatientToARegion_InvalidHorizontal_False() {
        assertFalse(histo.addAPatientToRegion(10, 15));

    }

    @Test
    public void deleteAPatient_Valid_True() {
        histo.addAPatientToRegion(10, 5);
        assertTrue(histo.deleteAPatientFromRegion(10, 5));

    }

    @Test
    public void deleteAPatient_Invalid_False() {
        assertFalse(histo.deleteAPatientFromRegion(10, 5));

    }

    @Test
    public void getPatientsCountInRegion_True() {
        for (int i = 0; i < 5; i++)
            histo.addAPatientToRegion(10, 5);
        try {
            assertEquals(5, histo.getPatientsCountInRegion(10, 5));
        } catch (IndexOutOfBoundsException e) {
        }

    }

    @Test
    public void getPatientsCountInRegion_invalidOutOfIndexRange_ThrowException() {
        try {
            histo.getPatientsCountInRegion(25, 5);
        } catch (IndexOutOfBoundsException e) {
        }

    }

}
