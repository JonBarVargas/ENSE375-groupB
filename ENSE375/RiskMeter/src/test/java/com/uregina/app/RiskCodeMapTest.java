//Jonathan Vargas
//200389468
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
    ArrayList dummyCases = new ArrayList();
    boolean aux;
    boolean correctCode;

    @Before
    public void setUp(){
        testRiskMap = new RiskCodeMap();
        VTestCoordinate = 0;
        HTestCoordinate = 2;
        dummyCases.add(2);
        dummyCases.add(3);
        dummyCases.add(4);
        correctCode = false;

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
        correctCode = false;
        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'G')
            correctCode = true;
        assertTrue(correctCode);
    }

    @Test
    public void update_Risks()
    {
        ArrayList cases = new ArrayList();
        cases.add(0);
        cases.add(1);
        cases.add(2);
       
        assertTrue(testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 3, cases));
    }

    @Test
    public void test_B()
    {
        correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(0);
        cases.add(1);
        cases.add(2);
        
        aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 1, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'B')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_Y()
    {
        correctCode = false;
        ArrayList cases = new ArrayList();
        cases.add(3);
        cases.add(4);
        cases.add(5);

        aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 1, cases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'Y')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_O()
    {
        correctCode = false;
        
        aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 7, dummyCases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'O')
            correctCode = true;

        assertTrue(correctCode);
    }
    @Test
    public void test_R()
    {
        correctCode = false;
        
        aux = testRiskMap.updateRiskInARegion(VTestCoordinate, HTestCoordinate, 10, dummyCases);

        if(testRiskMap.getRiskInARegion(VTestCoordinate, HTestCoordinate) == 'R')
            correctCode = true;

        assertTrue(correctCode);
    }
}
