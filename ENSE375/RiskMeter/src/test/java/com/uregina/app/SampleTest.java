package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.*;
import java.io.*;

/**
 * Example of how a Unit test can simulate System.in and System.out.
 * Don't update this file
 */
public class SampleTest 
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
    public void SimpleProgramTest()
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
    
    @Test
    public void SimpleProgramTest2()
    {
    
	assertTrue(true);
    }
}

