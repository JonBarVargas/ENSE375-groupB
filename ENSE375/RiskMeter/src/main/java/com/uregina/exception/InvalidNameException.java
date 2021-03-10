package com.uregina.exception;
import java.io.*;
/**
* This exception is thrown when an invalid patient name is entered
*/
public class InvalidNameException extends Exception{
	private String name;
	
	public InvalidNameException(String name){
		super("\""+name+"\" is an invalid patient name");
		this.name=name;
	}
	public String getTheInvalidName(){
		return name;
	}
}
