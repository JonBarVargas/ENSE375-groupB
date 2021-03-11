package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for PatientHistogram.
 */
public class PatientHistogramTest {

    @Test
    public void addPatientToARegion_Valid_True() {
        PatientHistogram histo = new PatientHistogram();
        assertTrue(histo.addAPatientToRegion(10, 5));
    }

    @Test
    public void addPatientToARegion_InvalidVertical_False() {
        PatientHistogram histo = new PatientHistogram();
        assertFalse(histo.addAPatientToRegion(25, 5));

    }

    @Test
    public void addPatientToARegion_InvalidHorizontal_False() {
        PatientHistogram histo = new PatientHistogram();
        assertFalse(histo.addAPatientToRegion(10, 15));

    }

    @Test
    public void deleteAPatient_Valid_True() {
        PatientHistogram histo = new PatientHistogram();
        histo.addAPatientToRegion(10, 5);
        assertTrue(histo.deleteAPatientFromRegion(10, 5));

    }

    @Test
    public void deleteAPatient_Invalid_False() {
        PatientHistogram histo = new PatientHistogram();
        assertFalse(histo.deleteAPatientFromRegion(10, 5));

    }

    @Test
    public void getPatientsCountInRegion_True() {
        PatientHistogram histo = new PatientHistogram();
        for (int i = 0; i < 5; i++)
            histo.addAPatientToRegion(10, 5);
        try {
            assertEquals(5, histo.getPatientsCountInRegion(10, 5));
        } catch (IndexOutOfBoundsException e) {
        }

    }

    @Test
    public void getPatientsCountInRegion_invalidOutOfIndexRange_ThrowException() {
        PatientHistogram histo = new PatientHistogram();
        try {
            histo.getPatientsCountInRegion(25, 5);
        } catch (IndexOutOfBoundsException e) {
        }

    }

}
