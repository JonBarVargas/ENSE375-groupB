//Karlee Fidek
package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.*;
import org.junit.*;

public class AppAddPatientTest {

	private App app;
	
	private final InputStream systemIn = System.in;
	private final OutputStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;


	@Before
	public void setUpOutput() {
		app = new App();
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	private void provideInput(String data) {
	        testIn = new ByteArrayInputStream(data.getBytes());
        	System.setIn(testIn);
	}

	private String getOutput() {
        	return testOut.toString();
    	}

    	@After
    	public void restoreSystemInputOutput() {
        	System.setIn(systemIn);
        	System.setOut(systemOut);
    	}

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
}
