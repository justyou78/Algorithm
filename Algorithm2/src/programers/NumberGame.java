package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGame {
	 public int solution(int[] A, int[] B) {
	        int answer = 0;
		/*
		 * 둘다 오름차순 정렬
		 * A만큼 for문돌려
		 * A가 크면 b 인덱스를 증가시켜
		 * b가 크면 승점 올려주고 b 인덱스 증가시켜
		
		*/
	         Arrays.sort(A);
	         Arrays.sort(B);
	         int index = 0;
	         for (int i = 0; i < B.length; i++) {
	        	 System.out.println(A[i]);
				if(A[index] < B[i]) {
					answer++;
					index++;
				}
				
			}
	        
	        
	       
	        return answer;
	    }
}


