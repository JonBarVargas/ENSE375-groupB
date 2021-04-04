//Karlee Fidek
package com.uregina.app;
import java.util.ArrayList;

public class PatientList {
	private ArrayList<Patient> patientList;
	
    	public PatientList() {
    	    patientList = new ArrayList<Patient>();
    	}
	
    	/**
	*
	* @return boolean: true if the patient can be added to the list 
	*/
    	public boolean addPatient(Patient patient) {
	    if(patient == null || getPatient(patient.getID()) != null) {
	        return false;
	    }
    	
	    try {
	        patientList.add(patient);
	    } catch(Exception e) {
	        return false;
	    }
    	
	    return true;
    	}
	
    	/**
	*
	* @return boolean: true if the patient is removed from the list 
	*/
    	public boolean deletePatient(int index) {
	    try {
		patientList.remove(index);
	    } catch(IndexOutOfBoundsException e) { 
		return false;
	    }
		
    	    return true;
    	}
	
    	public Patient getPatient(String ID) {
	    for (Patient patient : patientList) {
		if (patient.getID().equals(ID)) {
		    return patient;
		}
    	    }
		
	    return null;
    	}
	
    	public int getNumberofPatients() {
    	    return patientList.size();
    	}
}
