package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hindex {
	 public int solution(int[] citations) {
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        for (int i = 0; i < citations.length; i++) {
				al.add(citations[i]);
			}
	        al.sort(Collections.reverseOrder());
	        int count = 1;
	        while(count <= al.size()) {
	        	if(count > al.get(count-1)) {
	        		break;
	        	}
	        	count++;
	        }
	        return count-1;
	    }
	}