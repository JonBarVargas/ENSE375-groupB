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

public class deletePatientTest {
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
	



}
