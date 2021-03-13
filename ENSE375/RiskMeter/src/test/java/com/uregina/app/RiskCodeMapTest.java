package com.uregina.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jdk.jfr.Timestamp;

import java.util.*;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
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
        RiskCodeMap risk = new RiskCodeMap();
        if(risk.getRiskInARegion(0, 2) == 'G')
            correctCode = true;
        assertTrue(correctCode);
    }

    @Test
    public void update_Risks_Ideal_input()
    {
        int VIndex = 0; 
        int HIndex = 2;
        RiskCodeMap risk = new RiskCodeMap();
        ArrayList cases = new ArrayList();
        cases.add(2);
        cases.add(3);
        cases.add(4);
       
        assertTrue( risk.updateRiskInARegion(VIndex, HIndex, 3, cases));
    }
}
