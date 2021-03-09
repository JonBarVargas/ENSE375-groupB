package com.uregina.app;
import java.util.Scanner;
import java.util.ArrayList;
import com.uregina.exception.*;
/**
 * <h1>RiskMeter</h1>
 * This program keeps track of the active cases of some epidemic disease
 * in a city and report the risk code for each region in the city.
 * <p>
 * <b> Note: <b> not tested
 * 
 * @author George Daoud
 * @version 1.0
 */
public class App 
{
    private PatientList patientList;
    private PatientHistogram histogram;
    private RiskCodeMap riskCodeMap;
    /**
    * Constructor that initalize all private data
    */
    public App()
    {
    	patientList=new PatientList();
    	histogram= new PatientHistogram();
    	riskCodeMap= new RiskCodeMap();
    }
    /**
    * <p>Main method that repeatedly shows a menu for the user to select</p>
    * <p></p>
    * 1. Add a new patient to a patient list and update the patient histogram and risk map<br>
    * 2. Remove a patient from the patient list and update the patient histogram and risk map<br>
    * 3. Print the risk map<br>
    * @param args: unused
    */
    public static void main( String[] args )
    {
	App app=new App();
	Scanner myInput = new Scanner( System.in );
	boolean stop=false;
	String patientName,patientID,patientpostalCode;
	int patientAge;
	while(!stop)
	{	
		showMenu();
		int choice=getAChoice();
		switch(choice)
		{
			case 1:
				patientName=myInput.nextLine();
				patientID=myInput.nextLine();
				patientpostalCode=myInput.nextLine();
				patientAge=myInput.nextInt();
				if(app.addPatient(patientName,patientID,patientpostalCode,patientAge))
				{
	 			   	System.out.println("\tPatient has been added successfully");				
				}
				else
				{
				  	System.out.println("\tPatient failed to be added");
				}
				break;
			case 2:
				patientID=myInput.nextLine();
				if(app.deletePatient(patientID))
				{
	 			   	System.out.println("\tPatient has been removed successfully");				
				}
				else
				{
				  	System.out.println("\tPatient failed to be removed");
				}
			case 3:
				System.out.print("\t");
				for(int j=0;j<10;j++){
					System.out.print("  "+j);
				}
				System.out.println("");
				for(int i=0;i<20;i++){
					System.out.print('A'+i);
					for(int j=0;j<10;j++){
						System.out.print("  "+app.riskCodeMap.getRiskInARegion(i,j));	
					}
					System.out.println("");
				}
				break;	
			case 4:
				stop=true;
				break;
			default:
				System.out.println("Invalid choice");
		}
		System.out.println("*******************************************");
	}
    }
    /**
    * <p>This method shows the available options to the user</p>
    * <p></p>
    * 1. Add a new patient<br>
    * 2. Remove a patient <br>
    * 3. Print the risk map <br>
    * 4. End the program <br>
    */
    public static void showMenu()
    {
   	System.out.println("Menu :");
	System.out.println( "\t1. Add a patient" );
	System.out.println( "\t2. Remove a patient" );
	System.out.println( "\t3. Show the risk code map" );
	System.out.println( "\t4. Exit" );
    }
    /**
    * <p>This method asks the user to enter an integer between 1 to 4</p>
    * @return int the value choices by the user from 1 to 4 or 0 for a bad choice
    */
    public static int getAChoice()
    {
	Scanner myInput = new Scanner( System.in );
	System.out.print( "Enter a number from 1 to 4: " );
	int choice;
	try{
		choice= myInput.nextInt();
	}
	catch(Exception e)
	{
		choice=0;
	}
	if(choice<0|choice>4){
		choice=0;
	}
    	return choice;
    }
    /**
    * <p>This method removes a patient from the patient list 
    * and update the patient histogram and risk map</p>
    * <p></p>
    * the function prints tyhe following messages in case of fail <br>
    * <pre>"\tPatient Not Found"                  if the patient is not found in the list</pre>
    * <pre>"\tFailed to update the patient Count" if the function failed to update the histogram</pre>
    * <pre>"\tFailed to update the risk code map" if the function failed to update the risk map</pre>
    * The function stops if any failure occurs
    * @param patientID a string contains the ID of the patient that should be removed
    * @return boolean which is false if it failed
    */
    public boolean deletePatient(String patientID)
    {
    	Patient patient=patientList.getPatient(patientID);
    	if(patient==null)
    	{
    		System.out.println( "\tPatient Not Found" );
    	}
    	int HIndex=patient.getPostalCode().getRegionHorizontalIndex();
    	int VIndex=patient.getPostalCode().getRegionVerticalIndex();
    	if(!histogram.deleteAPatientFromRegion(VIndex,HIndex))
    	{
	    	System.out.println( "\tFailed to update the patient Count" );
    	}
    	int caseCount=histogram.getPatientsCountInRegion(VIndex,HIndex);
    	ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
    	if(!riskCodeMap.updateRiskInARegion(VIndex,HIndex,caseCount,neighboursCaseCount))
    	{
    		System.out.println( "\tFailed to update the risk code map" );
    		return false;
    	}
    	return true;
    }
    /**
    * <p>This method adds a patient to the patient list 
    * and update the patient histogram and risk map</p>
    * <p>The function prints tyhe following messages in case of fail</p>
    * <pre>"\tInvalid PostalCode"           	        if the patient postal code is invalid </pre>
    * <pre>"\tInvalid patient name"			if the patient name is invalid</pre>
    * <pre>"\tInvalid patient age"				if the patient age is invalid </pre>
    * <pre>"\tInvalid patient ID"				if the patient ID is invalid </pre>
    * <pre>"\tFailed to add a patient to a patientList"	if the patient can't be added to the patient list </pre>
    * <pre>"\tFailed to assign  a patient to a region"	if the function failed to update the histogram </pre> 
    * <pre>"\tFailed to update the risk code map"		if the function failed to update the risk map </pre>
    * The function stops if any failure occurs 
    * @param patientName 	a string contains the name of the patient that should be added
    * @param patientID 	a string contains the ID of the patient that should b  added
    * @param patientpostalCode a string contains the postal code of the patient that should be added
    * @param patientAge 	an integer contains the age of the patient that should be added
    * @return boolean which is false if it failed
    */
    public boolean addPatient(String patientName,String patientID,String patientpostalCode, int patientAge)
    {
    	PostalCode postalCode=null;
    	try{
    		postalCode=new PostalCode(patientpostalCode);
    	}
    	catch(InvalidPostalCodeException e){
    		System.out.println( "\tInvalid PostalCode" );
    	}
    	Patient patient=null;
    	try{
    		patient= new Patient(patientName, patientID, patientAge,postalCode);
    	}
    	catch(InvalidNameException e){
    		System.out.println( "\tInvalid patient name" );
    		return false;
    	}
    	catch(InvalidAgeException e){
    		System.out.println( "\tInvalid patient age" );
    		return false;
    	}
    	catch(InvalidIDException e){
    		System.out.println( "\tInvalid patient ID" );
    		return true;
    	}
    	catch(InvalidPostalCodeException e){
    		System.out.println( "\tInvalid patient ID" );
    		return false;
    	}

    	if(!patientList.addPatient(patient))
    	{
    		System.out.println( "\tFailed to add a patient to a patientList" );
    		return false;
    	}
    	int HIndex=postalCode.getRegionHorizontalIndex();
    	int VIndex=postalCode.getRegionVerticalIndex();
    	if(!histogram.addAPatientToRegion(VIndex,HIndex))
    	{
    		System.out.println( "\tFailed to assign  a patient to a region" );
    		return false;
    	}
    	int caseCount=histogram.getPatientsCountInRegion(VIndex,HIndex);
    	ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
    	if(!riskCodeMap.updateRiskInARegion(VIndex,HIndex,caseCount,neighboursCaseCount))
    	{
    		System.out.println( "\tFailed to update the risk code map" );
    		return false;
    	}
    	return true;
    }
}
