//Jonathan Vargas
package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class AppAddPatientTestVer2 {

	private App testApp;
    private String validName;
    private String invalidName;
    private String validPostalCode;
	private String invalidPostalCode;
    private String validPatientID;
    private String invalidPatientID;
    private int validAge;
    private int invalidAgeNeg;
    private int invalidAgeMAX;
    private boolean testState;

    @Before
    public void setUP(){
        testApp = new App();
        validName = "JuanTheTester";
        invalidName ="WhatDoYouMean !@%^#)( is not a legal name?";
        validPostalCode = "K1A-5G8";
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
		boolean yeet = testApp.addPatient(validName, validPatientID, validPostalCode, validAge);
		//boolean yeeter = testApp.addPatient();
		assertTrue(yeet);
	}
	
	@Test
	public void addPatient_invalidPostalCode_true() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, validAge);
		assertTrue(testState);
	}
	
	@Test
	public void addPatient_invalidAge_false_neg() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, invalidAgeNeg);
		assertFalse(testState);
	}

    @Test
	public void addPatient_invalidAge_false_max() {
		testState = testApp.addPatient(validName, validPatientID, validPostalCode, invalidAgeMAX);
		assertFalse(testState);
	}
	
	@Test
	public void addPatient_invalidId_false() {
		testState = testApp.addPatient(validName, invalidPatientID, validPostalCode, validAge);
		assertFalse(testState);
	}
	
	@Test
	public void addPatient_invalidName_false() {
		testState = testApp.addPatient(invalidName, validPatientID, validPostalCode, validAge);
		assertFalse(testState);
	}
	
	@Test
	//This test is supposed to test the historgram bounds however the REGEX implementation from
	//Postalcode.java sees it as an improper postal code 
	public void addPatient_Region_false() {
		testState = testApp.addPatient(validName, validPatientID, "K1A-10G8", validAge);
		assertFalse(testState);
	}

	@Test
	public void addPatient_unableToAddPatientList() {
		testApp.addPatient(validName, validPatientID, validPostalCode, validAge);
		testState = testApp.addPatient("winchester", validPatientID, validPostalCode, 90);
		assertFalse(testState);
	}
	
}