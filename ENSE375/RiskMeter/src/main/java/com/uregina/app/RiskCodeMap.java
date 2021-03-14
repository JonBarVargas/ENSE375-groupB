package com.uregina.app;

// import com.uregina.exception.*;
import java.util.*;

public class RiskCodeMap {

	final int Y_MAX = 20;
	final int X_MAX = 10;
	private char[][] riskCode;

	public RiskCodeMap() {
		riskCode = new char[X_MAX][Y_MAX];
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				this.riskCode[j][i] = 'G';
			}
		}
	}

	/**
	 *
	 * @return boolean: true if the function could update the risk code in that
	 *         region
	 */
	public boolean updateRiskInARegion(int VIndex, int HIndex, int caseCount, ArrayList<Integer> neighboursCaseCount) {
		if (VIndex < Y_MAX && VIndex >= 0 && 
			HIndex < X_MAX && HIndex >= 0 && caseCount >= 0) {
			Collections.sort(neighboursCaseCount);
			int mid = neighboursCaseCount.size() / 2;
			int median = 0;
			if (neighboursCaseCount.size() % 2 == 0) {
				median = (neighboursCaseCount.get(mid - 1) + neighboursCaseCount.get(mid)) / 2;
			} else {
				median = neighboursCaseCount.get(mid);
			}
			this.riskCode[HIndex][VIndex] = calculateRisk(Math.max(median,caseCount));
			return true;

		}

		return false;
	}

	public char getRiskInARegion(int VIndex, int HIndex) throws IndexOutOfBoundsException {
		if(  	VIndex < Y_MAX && VIndex >= 0 &&
				HIndex < X_MAX && HIndex >= 0){
					return riskCode[HIndex][VIndex];
		} else{
			throw new IndexOutOfBoundsException();
		}
		
	}


	public char calculateRisk(int caseCount){
		if (caseCount > 10 ) return 'R';
		if (caseCount >= 7 && caseCount < 10) return 'O';
		if (caseCount >= 3 && caseCount < 7) return 'Y';
		if (caseCount >= 0 && caseCount < 3) return 'B';
		return 'G';


	}
}
