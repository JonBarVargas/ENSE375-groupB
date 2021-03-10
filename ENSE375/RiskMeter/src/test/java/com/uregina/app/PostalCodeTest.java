package com.uregina.app;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple PostalCode.
 */
public class PostalCodeTest 
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
    public void isValidPostCode_Valid_True(){
       
        assertTrue(PostalCode.isValidPostalCode("K1T-5X2"));
    }

    @Test
    public void isValidPostCode_NonValidLastLetter_False(){
       
        assertFalse(PostalCode.isValidPostalCode("K1T-5XF"));
    }

    @Test
    public void isValidPostCode_NonValidSpace_False(){
       
        assertFalse(PostalCode.isValidPostalCode("K1T 5X2"));
    }

    @Test
    public void isValidPostCode_NonValidLowerCase_False(){
       
        assertFalse(PostalCode.isValidPostalCode("K1t-5xf"));
    }
}
