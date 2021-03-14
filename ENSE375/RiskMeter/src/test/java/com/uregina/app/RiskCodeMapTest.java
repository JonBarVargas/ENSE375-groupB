package com.uregina.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import jdk.jfr.Timestamp;

import java.util.*;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
    private RiskCodeMap testRiskMap;
    private int VTestCoordinate;
    private int HTestCoordinate;
    @Before
    public void setUp(){
        testRiskMap = new RiskCodeMap();
        VTestCoordinate = 0;
        HTestCoordinate = 2;
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void return_Risk_In_A_Region()
    {   
        boolean correctCode = false;
        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'G')
            correctCode = true;
        assertTrue(correctCode);
    }

    @Test
    public void update_Risks()
    {
        int VIndex = 0; 
        int HIndex = 1;
        ArrayList cases = new ArrayList();
        cases.add(2);
        cases.add(3);
        cases.add(4);
       
        assertTrue( testRiskMap.updateRiskInARegion(VIndex, HIndex, 3, cases));
    }

    @Test
    public void test_B()
    {
        boolean correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(0);
        cases.add(1);
        cases.add(2);
        boolean aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 1, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'B')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_Y()
    {
        boolean correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(3);
        cases.add(4);
        cases.add(5);
        boolean aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 1, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'Y')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_O()
    {
        boolean correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(3);
        cases.add(4);
        cases.add(5);
        boolean aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 7, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'Y')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_R()
    {
        boolean correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(3);
        cases.add(4);
        cases.add(5);
        boolean aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 10, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'R')
            correctCode = true;

        assertTrue(correctCode);
    }
}
