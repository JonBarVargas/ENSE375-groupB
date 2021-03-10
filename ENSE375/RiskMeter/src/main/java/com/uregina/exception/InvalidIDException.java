package com.uregina.exception;
import java.io.*;
/**
* This exception is thrown when an invalid patient ID is entered
*
*/
public class InvalidIDException extends Exception{
	private String ID;
	
	public InvalidIDException(String ID){
		super("\""+ID+"\" is an invalid ID");
		this.ID=ID;
	}
	public String getTheInvalidID(){
		return ID;
	}
}
