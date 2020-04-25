package solution;

import java.util.ArrayList;

public class Programmers42841 {
	 public int solution(int[][] baseball) {
	        int answer = 0;
	        ArrayList<String> allNum = new ArrayList<String>();
	        
	        for (int i = 1; i <= 9; i++) {
	        	for (int j = 1; j <= 9; j++) {
					for (int k = 1; k <= 9; k++) {
						if(!(i == j  || j== k || k== i)) {
							allNum.add(String.valueOf(i*100 + j*10 + k*1));
						}
					}
				}
			}
	        
	       
	        for (int i = 0; i < allNum.size(); i++) {
	        	
	        	boolean flag = true;
				String num = allNum.get(i);
				for (int j = 0; j < baseball.length; j++) {
					
					int strike = findStrike(String.valueOf(num), String.valueOf(baseball[j][0]));
					int ball= findBall(String.valueOf(num), String.valueOf(baseball[j][0]))-strike;
					if(!(baseball[j][1] == strike && ball == baseball[j][2])) {
						
						flag =false;
						break;
					}
					
				}
				if(flag) {
					
					answer++;
				}
				
			}
	        
	        
	        return answer;
	    }
	 
	 public int findStrike(String num, String num2) {
		int count =0;
		for (int i = 0; i < 3; i++) {
			count = num.charAt(i) == num2.charAt(i) ? count+1 : count; 
			
		}
		
		return count;
	 }
	 
	 public int findBall(String num, String num2) {
		 int count = 0;
		 for (int i = 0; i < 3; i++) {
			count = num.contains(String.valueOf(num2.charAt(i))) ? count+1 : count ;
		}
		 
		 return count;
		 
	 }
}
