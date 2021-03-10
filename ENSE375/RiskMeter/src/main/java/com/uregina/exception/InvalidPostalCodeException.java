package com.uregina.exception;
import java.io.*;
/**
* This exception is thrown when an invalid postal code is entered
*
*/
public class InvalidPostalCodeException extends Exception{
	
	public InvalidPostalCodeException(){
		super("Invalid postal code");
	}
}
