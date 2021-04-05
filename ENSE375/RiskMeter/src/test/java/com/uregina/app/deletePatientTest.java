package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class deletePatientTest {
	
	App app = new App();
	
	@Test
	public void deletePatient_validPatient_true() {
		boolean successful_delete = app.deletePatient("123456789");
		assertTrue(successful_delete);
	}
	
	@Test
	public void deletePatient_patientIDNotFound() {
		boolean successful_delete = app.deletePatient("120000089");
		assertFalse(successful_delete);
	}
	
	@Test
	public void deletePatient_patientIDInvalid() {
		boolean successful_delete = app.deletePatient("123456");
		assertFalse(successful_delete);
	}
	



}
