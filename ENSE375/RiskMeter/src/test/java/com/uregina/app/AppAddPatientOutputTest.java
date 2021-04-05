package com.uregina.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

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
    public void addPatient_validPatient_riskCodeMapUpdatedVerticalEdge(){
        App app = new App();
        
        String seperator = System.getProperty("line.separator");
        provideInput("jeff" +seperator +"123456700" + seperator + 
        "K1S-4X2" + seperator +"25" +seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "123456000"+seperator + "K1S-5X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "123450701"+seperator + "K1S-6X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "120000701"+seperator + "K1T-5X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
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
        "S  G  G  G  G  B  B  B  G  G  G"+seperator +
        "T  G  G  G  G  B  B  B  G  G  G"+seperator;
        App.printMapOption(app);
        String actualOutput = getOutput();
       
        assertTrue(actualOutput.toLowerCase().contains(new String(expectedOutput.toLowerCase().getBytes(Charset.defaultCharset()))));
    }





    @Test
    public void addPatient_validPatient_riskCodeMapUpdatedHorizontalEdge(){
        App app = new App();
        
        String seperator = System.getProperty("line.separator");
        provideInput("jeff"+seperator + "123456000"+seperator + "K1E-9X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "123450701"+seperator + "K1F-9X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "120000701"+seperator + "K1G-9X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "120000702"+seperator + "K1G-8X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        provideInput("jeff"+seperator + "120000703"+seperator + "K1E-8X2"+seperator + "25"+seperator);
        App.addPatientOption(app);
        String expectedOutput = "" +
        "A  G  G  G  G  G  G  G  G  G  G"+seperator +
        "B  G  G  G  G  G  G  G  G  G  G"+seperator +
        "C  G  G  G  G  G  G  G  G  G  G"+seperator +
        "D  G  G  G  G  G  G  G  G  G  G"+seperator +
        "E  G  G  G  G  G  G  G  G  B  B"+seperator +
        "F  G  G  G  G  G  G  G  G  B  B"+seperator +
        "G  G  G  G  G  G  G  G  G  B  B"+seperator +
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
        "S  G  G  G  G  G  G  G  G  G  G"+seperator +
        "T  G  G  G  G  G  G  G  G  G  G"+seperator;
        App.printMapOption(app);
        String actualOutput = getOutput();
       
        assertTrue(actualOutput.toLowerCase().contains(new String(expectedOutput.toLowerCase().getBytes(Charset.defaultCharset()))));
    }





    @Test
    public void addPatient_validPatient_riskCodeMapUpdatedOrangeCenter(){
        App app = new App();
        
        String seperator = System.getProperty("line.separator");

        for (int i = 0; i < 9; i++){
            provideInput("jeff"+seperator + "12345600"+i+seperator + "K1E-5X2"+seperator + "25"+seperator);
            App.addPatientOption(app);
        }
        for (int i = 0; i < 9; i++){
            provideInput("jeff"+seperator + "12345610"+i+seperator + "K1F-5X2"+seperator + "25"+seperator);
            App.addPatientOption(app);
        }
        for (int i = 0; i < 9; i++){
            provideInput("jeff"+seperator + "12345620"+i+seperator + "K1F-4X2"+seperator + "25"+seperator);
            App.addPatientOption(app);
        }
        for (int i = 0; i < 9; i++){
            provideInput("jeff"+seperator + "12345630"+i+seperator + "K1F-3X2"+seperator + "25"+seperator);
            App.addPatientOption(app);
        }
        for (int i = 0; i < 9; i++){
            provideInput("jeff"+seperator + "12345640"+i+seperator + "K1E-3X2"+seperator + "25"+seperator);
            App.addPatientOption(app);
        }
     
        String expectedOutput = "" +
        "A  G  G  G  G  G  G  G  G  G  G"+seperator +
        "B  G  G  G  G  G  G  G  G  G  G"+seperator +
        "C  G  G  G  G  G  G  G  G  G  G"+seperator +
        "D  G  G  G  G  G  G  G  G  G  G"+seperator +
        "E  G  G  G  O  O  O  G  G  G  G"+seperator +
        "F  G  G  G  O  O  O  G  G  G  G"+seperator +
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
        "S  G  G  G  G  G  G  G  G  G  G"+seperator +
        "T  G  G  G  G  G  G  G  G  G  G"+seperator;
        App.printMapOption(app);
        String actualOutput = getOutput();
       
        assertTrue(actualOutput.toLowerCase().contains(new String(expectedOutput.toLowerCase().getBytes(Charset.defaultCharset()))));
    }

}
