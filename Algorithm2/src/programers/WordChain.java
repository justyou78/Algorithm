package programers;

import java.util.ArrayList;
import java.util.HashMap;

public class WordChain {
	  public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	       //일단 arraylist로 하고 그 다음  try알고리즘을 사용해봅시다. 
		/*
		 * 초기값 첫번째글자 설정
		 * 
		 *  while문 돌려주면서  turn변수 증가  boolean check 변수;
		 *  내부에서 for문돌려주고 첫번째글짜확인  일치 ? 처번째끌짜 끝자로 변경
		 *  
		
		*/
	        ArrayList<String> al = new ArrayList<String>();
	        char word=words[0].charAt(0);
	        int count = 0;
	        int turn = 0 ;
	        boolean check = true;
	        while(check) {
	        
	        	turn++;
	        	for (int j = 0; j < n; j++) {
	        		if(count < words.length ) {
	        		
	        			if(words[count].charAt(0) == word && !al.contains(words[count])) {
	        				word = words[count].charAt(words[count].length()-1);
	        				al.add(words[count]);
	        				
	        			}
	        			else {
	        				answer[0] = j+1;
	        				answer[1] = turn;
	        				check =false;
	        				break;
	        			}
	        		}
	        		else {
	        			check =false;
	        			answer[0] = 0;
	        			answer[1] = 0;
	        			break;
	        			
	        		}
	        		count++;
				}
	        }
	        
	        
	        return answer;
	    }
	  
	
	  
	 
}


