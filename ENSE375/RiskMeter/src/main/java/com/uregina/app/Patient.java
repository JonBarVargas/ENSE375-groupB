package com.uregina.app;
import com.uregina.exception.*;


public class Patient 
{
	private String name;
	private String ID;
	private int age;
	private PostalCode postalCode;
	
	public Patient(String name, String ID, int age, PostalCode postalCode) throws InvalidNameException, InvalidAgeException ,InvalidIDException, InvalidPostalCodeException
	{
		//ToDo: add you code here
	}
	public String getName()
	{
		//ToDo: add your code here (you can update the return statement)
		return "";
	}
	public String getID()
	{
		//ToDo: add your code here (you can update the return statement) 
		return "";
	}
	public int getAge()
	{
		//ToDo: add your code here (you can update the return statement) 
		return 0;
	}
	public PostalCode getPostalCode()
	{	
		//ToDo: add your code here (you can update the return statement)
		return null;
	}
	/**
	*
	* @return boolean: true if the age is corrected set 
	*/
	public boolean setAge(int age)
	{	
		//ToDo: add your code here
		return true;
	}
	/**
	*
	* @return boolean: true if the postal code is corrected set 
	*/
	public boolean setPostalCode(PostalCode postalCode)
	{
		//ToDo: add your code here
		return true;
	}
}
