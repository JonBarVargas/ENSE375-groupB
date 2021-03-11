package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.*;
import java.io.*;

/**
 * Unit test for App.
 */
public class AppTest 
{

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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void getAChoice_NonValid_Equals()
    {
    
	provideInput("5");
	try{
        	assertEquals(0, App.getAChoice());
        }
        catch(Exception e)
        {
        	assertTrue(false);
        }
    }


    // @Test
    // public void addPatient()
    // {
    //     App app =  new App();
    //     PostalCode pc = new PostalCode("K1T-5X2");

    //     app.addPatient("STeve", "123456780", patientpostalCode, patientAge)
    // }
 }