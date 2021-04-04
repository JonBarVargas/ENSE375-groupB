//Jonathan Vargas
package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class AppAddPatientTest {

	private App testApp;
    private String validName;
    private String invalidName;
    private String validPostalCode;
    private String validPatientID;
    private String invalidPatientID;
    private int validAge;
    private int invalidAgeNag;
    private int invalidAgeMAX;
    private boolean testState;

    @Before
    public void setUP(){
        testApp = new App();
        validName = "JuanTheTester";
        invalidName ="WhatDoYouMean !@%^#)( is not a legal name?";
        validPostalCode = "K1A-SG8";
        invalidPostalCode = "YUH-6H5";
        validPatientID = "123456789";
        invalidPatientID = "88767";
        validAge = 30;
        invalidAgeNeg = -1;
        invalidAgeMAX = Integer.MAX_VALUE;
        testState = false;
    }

	
	@Test
	public void addPatient_validPatient_true() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, validAge);
		assertTrue(testState);
	}
	
	@Test
	public void addPatient_invalidPostalCode_false() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, validAge);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidAge_false_neg() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, invalidAgeNeg);
		assertFalse(true);
	}

    @Test
	public void addPatient_invalidAge_false_max() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, invalidAgeMAX);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidId_false() {
		testState = testApp.addPatient(validName, validPatientID, invalidPostalCode, validAge);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidName_false() {
		testState = testApp.addPatient(invalidName, validPatientID, validPostalCode, validAge);
		assertFalse(true);
	}
	
	
}