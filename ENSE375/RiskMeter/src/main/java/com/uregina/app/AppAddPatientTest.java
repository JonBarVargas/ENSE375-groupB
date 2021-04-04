//Karlee Fidek
package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppAddPatientTest {

	App app = new App();
	
	@Test
	public void addPatient_validPatient_true() {
		boolean addSuccessful = app.addPatient("Karlee", "112233445", "A4A-2F7", 21);
		assertTrue(false);
	}
	
	@Test
	public void addPatient_invalidPostalCode_false() {
		boolean addSuccessful = app.addPatient("Karlee", "112233445", "A4G3H8", 21);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidAge_false() {
		boolean addSuccessful = app.addPatient("Karlee", "112233445", "A4A-2F7", -1);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidId_false() {
		boolean addSuccessful = app.addPatient("Karlee", "1234", "A4A-2F7", 21);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_invalidName_false() {
		boolean addSuccessful = app.addPatient("Karlee&Fidek", "112233445", "A4A-2F7", 21);
		assertFalse(true);
	}
	
	@Test
	public void addPatient_RiskMap_false() {
		app.addPatient("Karlee", "112233445", "A4A-2F7", 21);
		boolean addSuccessful = app.addPatient("Dr. ElDarieby", "123456789", "A4A-2F7", 40);
		assertFalse(true);
	}
}
