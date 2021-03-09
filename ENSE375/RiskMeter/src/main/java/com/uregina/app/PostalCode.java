package com.uregina.app;
import com.uregina.exception.*;

public class PostalCode 
{
	private String postalCode;
    	public static boolean isValidPostalCode(String postalCode )
    	{
		//ToDo: add you code here
			return postalCode.matches("^K1[A-T]-[0-9][A-Z][0-9]");
    	}
    	public PostalCode(String postalCode) throws InvalidPostalCodeException
    	{
    		this.postalCode = postalCode;
    	}
    	public int getRegionVerticalIndex()
    	{
	    	//ToDo: add your code here (you can update the return statement) 
    		return 0;
    	}
    	public int getRegionHorizontalIndex()
    	{
    		//ToDo: add your code here (you can update the return statement) 
    		return 0;
    	}
    	public String getPostalCode()
    	{
    		//ToDo: add your code here (you can update the return statement) 
    		return "";
    	}
}
