package com.uregina.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;


import org.junit.Test;


public class AppAddPatientOutputTest {
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
    public void addPatient_validPatient_riskCodeMapUpdated(){
        App app = new App();
        provideInput("tristan\n123456700\nK1S-4X2\n25\n");
        App.addPatientOption(app);
        provideInput("tristan\n123456000\nK1S-5X2\n25\n");
        App.addPatientOption(app);
        provideInput("tristan\n123450701\nK1S-6X2\n25\n");
        App.addPatientOption(app);
        provideInput("tristan\n120000701\nK1T-5X2\n25\n");
        App.addPatientOption(app);
        String expectedOutput = "" +
        "A  G  G  G  G  G  G  G  G  G  G\r\n"+
        "B  G  G  G  G  G  G  G  G  G  G\r\n"+ 
        "C  G  G  G  G  G  G  G  G  G  G\r\n"+
        "D  G  G  G  G  G  G  G  G  G  G\r\n"+
        "E  G  G  G  G  G  G  G  G  G  G\r\n"+
        "F  G  G  G  G  G  G  G  G  G  G\r\n"+
        "G  G  G  G  G  G  G  G  G  G  G\r\n"+
        "H  G  G  G  G  G  G  G  G  G  G\r\n"+
        "I  G  G  G  G  G  G  G  G  G  G\r\n"+
        "J  G  G  G  G  G  G  G  G  G  G\r\n"+
        "K  G  G  G  G  G  G  G  G  G  G\r\n"+
        "L  G  G  G  G  G  G  G  G  G  G\r\n"+
        "M  G  G  G  G  G  G  G  G  G  G\r\n"+
        "N  G  G  G  G  G  G  G  G  G  G\r\n"+
        "O  G  G  G  G  G  G  G  G  G  G\r\n"+
        "P  G  G  G  G  G  G  G  G  G  G\r\n"+
        "Q  G  G  G  G  G  G  G  G  G  G\r\n"+
        "R  G  G  G  G  G  G  G  G  G  G\r\n"+
        "S  G  G  G  G  B  B  B  G  G  G\r\n"+
        "T  G  G  G  G  B  B  B  G  G  G\r\n";
        App.printMapOption(app);
        String actualOutput = getOutput();
        assertTrue(actualOutput.contains((CharSequence)expectedOutput));
    }


}
