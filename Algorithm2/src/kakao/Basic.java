package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Basic {
	  public int solution(int []A, int []B)
	    {
	        int answer = 0;
		/*
		 * 	두개의 배열이 있을 경우,  
		 * 
		*/
	       ArrayList<Integer> RowToHigh = new ArrayList<Integer>();
	       ArrayList<Integer> HighToRow = new ArrayList<Integer>();
	       
	       for (int i = 0; i < A.length; i++) {
			RowToHigh.add(A[i]);
			HighToRow.add(B[i]);
	    	   
	    	   
		}
	     Collections.sort(RowToHigh);
	     Collections.sort(HighToRow, Collections.reverseOrder());
	     
	    
	    for(int i  = 0; i < RowToHigh.size(); i++) {
	    	System.out.println(RowToHigh.get(i) +" " + HighToRow.get(i));
	    	answer  += (RowToHigh.get(i) * HighToRow.get(i));
	    }
	        return answer;
	    }
}
