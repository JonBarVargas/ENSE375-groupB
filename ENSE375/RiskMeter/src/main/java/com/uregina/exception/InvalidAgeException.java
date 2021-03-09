package com.uregina.exception;
import java.io.*;
/**
* This exception is thrown when an invalid patient age is entered
*
*/
public class InvalidAgeException extends Exception{
	private int age;
	
	public InvalidAgeException(int age){
		super("\""+age+"\" is an invalid age");
		this.age=age;
	}
	public int getTheInvalidAge(){
		return age;
	}
}
