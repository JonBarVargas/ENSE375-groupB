// Anupras Burokas
package com.uregina.app;
//import javax.naming.InvalidNameException;

import com.uregina.exception.*;


public class Patient 
{
	private String name;
	private String ID;
	private int age;
	private PostalCode postalCode;
	
	public Patient(String name, String ID, int age, PostalCode postalCode) throws InvalidAgeException ,InvalidIDException, InvalidPostalCodeException, InvalidNameException
	{
		if(name.matches("^[a-zA-Z .]*$")){
			this.name = name;
		} else{
			throw new InvalidNameException(name);
		}
		//This is a design constraint. Where we enter patients born around this century
		//are kept in our records. We would like to keep record of people that are active
		//patiets. After quick searches the oldest human was around 144 years old. 
		if((age >= 0) && (age <= 144)){
			this.age = age;
		} else{
			throw new InvalidAgeException(age);
		}
		if(ID.matches("(?=.*0)^[0-9]{9}$")){
			this.ID = ID;

		} else{
			throw new InvalidIDException(ID);
		}
		if(PostalCode.isValidPostalCode(postalCode.getPostalCode())){
			this.postalCode = postalCode;
		} else{
			throw new InvalidPostalCodeException();
		}
	}
	public String getName()
	{
		return name;
	}
	public String getID()
	{
		return ID;
	}
	public int getAge()
	{
		return age;
	}
	public PostalCode getPostalCode()
	{	
		return postalCode;
	}
	/**
	*
	* @return boolean: true if the age is corrected set 
	*/
	public boolean setAge(int age)
	{	
		if((age >= 0) && (age <= 144)){
			this.age = age;
			return true;
		} else{
			return false;
		}
	}
	/**
	*
	* @return boolean: true if the postal code is corrected set 
	*/
	public boolean setPostalCode(PostalCode postalCode)
	{
		if(PostalCode.isValidPostalCode(postalCode.getPostalCode())){
			this.postalCode = postalCode;
			return true;
		} else{
			return false;
		}
	}
}
