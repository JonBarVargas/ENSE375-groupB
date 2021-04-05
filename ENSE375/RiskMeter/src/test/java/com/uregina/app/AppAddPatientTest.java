//Karlee Fidek
package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppAddPatientTest {

	App app = new App();
	
	@Test
	public void addPatient_validPatient_true() {
		boolean addSuccessful = app.addPatient("Karlee", "112233445", "K1A-2F7", 21);
		assertTrue(addSuccessful);
	}
	
	@Test
	public void addPatient_invalidPostalCode_false() {
		boolean addSuccessful = app.addPatient("Karlee", "123456780", "A4G3H8", 21);
		assertFalse(addSuccessful);
	}
	
	@Test
	public void addPatient_invalidAge_false() {
		boolean addSuccessful = app.addPatient("Karlee", "112233445", "K1A-2F7", -1);
		assertFalse(addSuccessful);
	}
	
	@Test
	public void addPatient_invalidId_false() {
		boolean addSuccessful = app.addPatient("Karlee", "1234", "K1A-2F7", 21);
		assertFalse(addSuccessful);
	}
	
	@Test
	public void addPatient_invalidName_false() {
		boolean addSuccessful = app.addPatient("Karlee&Fidek", "112233445", "K1A-2F7", 21);
		assertFalse(addSuccessful);
	}
	
	@Test
	public void addPatient_addingToPatientListFails_false() {
		app.addPatient("Karlee", "112233445", "K1A-2F7", 21);
		boolean addSuccessful = app.addPatient("Dr. ElDarieby", "112233445", "K1A-2F7", 40);
		assertFalse(addSuccessful);
	}

	@Test
	public void addPatient_validPatient_true() {
		boolean addSuccessful = app.addPatient("Karlee", "123456789", "K1A-3T6", 21);
		assertTrue(addSuccessful);
	}
}
