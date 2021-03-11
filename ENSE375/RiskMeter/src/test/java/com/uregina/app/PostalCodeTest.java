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
    public void isValidPostCode_Valid_True(){
       
        assertTrue(PostalCode.isValidPostalCode("K1T-5X2"));
    }


    @Test
    public void isCorrectVerticalIndex_Correct_True(){
        PostalCode pc = null;
        try{
            pc = new PostalCode("K1B-5X2");

        }catch(Exception e){

        }
        assertEquals(1,pc.getRegionVerticalIndex());
    }

    @Test
    public void isCorrectHorizontalIndex_Correct_True(){
        PostalCode pc = null;
        try{
            pc = new PostalCode("K1B-5X2");

        }catch(Exception e){

        }
        assertEquals(5,pc.getRegionHorizontalIndex());
    }

    @Test
    public void isCorrectPostalCode_Correct_True(){
        PostalCode pc = null;
        try{
            pc = new PostalCode("K1B-5X2");

        }catch(Exception e){

        }
        assertEquals("K1B-5X2",pc.getPostalCode());
    }

    @Test
    public void makePostCode_True(){
       try{
        PostalCode pc = new PostalCode("K1T-5X2");
       }catch(Exception e){

       }
    }

    @Test
    public void makePostCode_False(){
       try{
        PostalCode pc = new PostalCode("K1T X2");
       }catch(Exception e){
       }
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
