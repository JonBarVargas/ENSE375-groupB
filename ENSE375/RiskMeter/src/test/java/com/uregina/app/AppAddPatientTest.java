//Karlee Fidek
package com.uregina.app;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.*;

public class AppAddPatientTest {

	private App app;
	
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;
	private String separator;

	@Before
	public void setUpOutput() {
		app = new App();
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		separator = System.getProperty("line.separator");
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

	//
	//Only need one of each failure case because the specific fail cases for each type of failure
	//(ID, postal code, name, age) are tested in the specific Class test classes
	//

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
        public void addPatient_adding2Patients_true() {
                app.addPatient("Karlee", "112233445", "K1A-2F7", 21);
                boolean addSuccessful = app.addPatient("Dr. ElDarieby", "123456789", "K1A-2F7", 40);
                assertTrue(addSuccessful);
        }

	//--------------------------------- Console Input Tests --------------------------------------//
	

	@Test
        public void addPatient_validPatientInput_successful() {
		provideInput("Karlee" + separator + "112233445" + separator + "K1A-2F7" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient has been added successfully";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        //
        //Only need one of each failure case because the specific fail cases for each type of failure
        //(ID, postal code, name, age) are tested in the specific Class test classes
        //

        @Test
        public void addPatient_invalidPostalCodeInput_fails() {
		provideInput("Karlee" + separator + "123456780" + separator + "A4G3H8" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient failed to be added";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        @Test
        public void addPatient_invalidAgeInput_fails() {
		provideInput("Karlee" + separator + "112233445" + separator + "K1A-2F7" + separator + "-1" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient failed to be added";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        @Test
        public void addPatient_invalidIdInput_fails() {
		provideInput("Karlee" + separator + "1234" + separator + "K1A-2F7" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient failed to be added";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        @Test
        public void addPatient_invalidNameInput_fails() {
		provideInput("Karlee&Fidek" + separator + "112233445" + separator + "K1A-2F7" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient failed to be added";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        @Test
        public void addPatient_addingToPatientListWithInputFails_fails() {
		provideInput("Karlee" + separator + "112233445" + separator + "K1A-2F7" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient has been added successfully";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
		
		provideInput("Dr. ElDarieby" + separator + "112233445" + separator + "K1A-2F7" + separator + "40" + separator);
		App.addPatientOption(app);
		expectedOutput = "\tPatient failed to be added";
                actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }

        @Test
        public void addPatient_adding2PatientsWithInput_successful() {
		provideInput("Karlee" + separator + "112233445" + separator + "K1A-2F7" + separator + "21" + separator);
		App.addPatientOption(app);
		String expectedOutput = "\tPatient has been added successfully";
                String actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
		
		provideInput("Dr. ElDarieby" + separator + "123456789" + separator + "K1A-2F7" + separator + "40" + separator);
		App.addPatientOption(app);
		expectedOutput = "\tPatient has been added successfully";
                actualOutput = getOutput();
		assertTrue(actualOutput.contains(expectedOutput));
        }
}
