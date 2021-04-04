package com.uregina.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class AppAddPatientInputTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    //App app;

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
    public void addPatient_validPatient_riskCodeMapUpdated(){
        String[] args = null;

        provideInput("1 John Smith\n 2\n");
        App.main(args);

    
    }


}
