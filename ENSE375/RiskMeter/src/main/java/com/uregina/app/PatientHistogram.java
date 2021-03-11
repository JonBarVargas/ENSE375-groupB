package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

public class PatientHistogram 
{

	final int Y_MAX = 20;
	final int X_MAX = 10;

	private int[][] patientCount;
    	public PatientHistogram() 
    	{
    		patientCount = new int[X_MAX][Y_MAX];
    	}
    	/**
	*
	* @return boolean: true if the a patient can be added from that region 
	*/
    	public boolean addAPatientToRegion(int VIndex,int HIndex)
    	{
    		if( VIndex < Y_MAX && VIndex >= 0 &&
				HIndex < X_MAX && HIndex >= 0){
					patientCount[HIndex][VIndex]++;
					return true;
				}
    		return false;	
    	}
	/**
	*
	* @return boolean: true if the a patient can be removed from that region 
	*/
    	public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
    	{
    		if( VIndex < Y_MAX && VIndex >= 0 &&
				HIndex < X_MAX && HIndex >= 0 && 
				patientCount[HIndex][VIndex] > 0){
					patientCount[HIndex][VIndex]--;
					return true;
				}
    		
    		return false;
    	}
    	public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
    	{
			if( VIndex < Y_MAX && VIndex >= 0 &&
				HIndex < X_MAX && HIndex >= 0){
					throw new IndexOutOfBoundsException();
				}
    		return patientCount[HIndex][VIndex];	
    	}
}
