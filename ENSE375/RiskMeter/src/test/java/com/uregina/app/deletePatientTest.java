package com.uregina.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;


import org.junit.Test;

public class DeletePatientTest {
	public static App app;


	@BeforeClass
	public static void setupApp(){
		app = new App();
	}
	
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
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
	public void deletePatient_validPatient_true() {
		String seperator = System.getProperty("line.separator");
        provideInput("Jeff" +seperator +"123456789" + seperator + 
        "K1S-4X2" + seperator +"25" +seperator);
		App.addPatientOption(app);
		boolean successful_delete = app.deletePatient("123456789");
		assertTrue(successful_delete);
	}
	
	@Test
	public void deletePatient_patientIDNotFound() {
		String seperator = System.getProperty("line.separator");
        provideInput("Jeff" +seperator +"123456789" + seperator + 
        "K1S-4X2" + seperator +"25" +seperator);
		App.addPatientOption(app);
		boolean successful_delete = app.deletePatient("120000089");
		assertFalse(successful_delete);
	}
	
	@Test
	public void deletePatient_patientIDInvalid() {
		String seperator = System.getProperty("line.separator");
        provideInput("Jeff" +seperator +"123456789" + seperator + 
        "K1S-4X2" + seperator +"25" +seperator);
		App.addPatientOption(app);
		boolean successful_delete = app.deletePatient("123456");
		assertFalse(successful_delete);
	}



	@Test
	public void deletePatient_riskCodeMapUpdated(){
		App app = new App();
        
        String seperator = System.getProperty("line.separator");

        provideInput("tristan"+seperator + "123456000"+seperator + "K1S-5X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("tristan"+seperator + "123450701"+seperator + "K1S-6X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("tristan"+seperator + "120000701"+seperator + "K1S-7X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
		//DELETE LAST PATIENT ADDED
		provideInput("120000701"+seperator);
		App.removePatientOption(app);


		String expectedOutput = "" +
        "A  G  G  G  G  G  G  G  G  G  G"+seperator +
        "B  G  G  G  G  G  G  G  G  G  G"+seperator +
        "C  G  G  G  G  G  G  G  G  G  G"+seperator +
        "D  G  G  G  G  G  G  G  G  G  G"+seperator +
        "E  G  G  G  G  G  G  G  G  G  G"+seperator +
        "F  G  G  G  G  G  G  G  G  G  G"+seperator +
        "G  G  G  G  G  G  G  G  G  G  G"+seperator +
        "H  G  G  G  G  G  G  G  G  G  G"+seperator +
        "I  G  G  G  G  G  G  G  G  G  G"+seperator +
        "J  G  G  G  G  G  G  G  G  G  G"+seperator +
        "K  G  G  G  G  G  G  G  G  G  G"+seperator +
        "L  G  G  G  G  G  G  G  G  G  G"+seperator +
        "M  G  G  G  G  G  G  G  G  G  G"+seperator +
        "N  G  G  G  G  G  G  G  G  G  G"+seperator +
        "O  G  G  G  G  G  G  G  G  G  G"+seperator +
        "P  G  G  G  G  G  G  G  G  G  G"+seperator +
        "Q  G  G  G  G  G  G  G  G  G  G"+seperator +
        "R  G  G  G  G  G  G  G  G  G  G"+seperator +
        "S  G  G  G  G  G  B  B  G  G  G"+seperator +
        "T  G  G  G  G  G  G  G  G  G  G"+seperator;
        App.printMapOption(app);
        String actualOutput = getOutput();

		assertTrue(actualOutput.toLowerCase().contains(new String(expectedOutput.toLowerCase().getBytes(Charset.defaultCharset()))));


	}
	



}
