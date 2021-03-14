package com.uregina.app;
import com.uregina.exception.*;
//Implemented by Tristan Brown-Hannibal
//200400651
public class PostalCode 
{
	private String postalCode;
    	public static boolean isValidPostalCode(String postalCode )
    	{
			return postalCode.matches("^K1[A-T]-[0-9][A-Z][0-9]");
    	}
    	public PostalCode(String postalCode) throws InvalidPostalCodeException
    	{
			if(PostalCode.isValidPostalCode(postalCode)){
    			this.postalCode = postalCode;
			} else {
				throw new InvalidPostalCodeException();
			}
    	}
    	public int getRegionVerticalIndex()
    	{
			char regionChar= Character.toLowerCase(postalCode.charAt(2));
			int asciiValue= (int)regionChar;
			int value= asciiValue-97;
			return value;
    	}
    	public int getRegionHorizontalIndex()
    	{
    		int value = Character.getNumericValue(postalCode.charAt(4));
    		return value;
    	}
    	public String getPostalCode()
    	{
    		
    		return postalCode;
    	}
}
