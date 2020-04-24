package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42628 {
	 public int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
	        
	        for (String command :  operations) {
	        	String[] st= command.split(" ");
	        	String firstCommand = st[0];
	        	String secondCommand = st[1];
	        	
	        	if(firstCommand.equals("I")) {
	        		pq.add(Integer.parseInt(secondCommand));
	        		pq2.add(Integer.parseInt(secondCommand));
	        	}
	        	else {
	        		if(pq.isEmpty()) continue;
	        		if(secondCommand.equals("1")) {
	        			int num =pq.poll();
	        			pq2.remove(num);
	        		}
	        		else {
	        			
	        			int num =pq2.poll();
	        			pq.remove(num);
	        			
	        		}
	        	}
	        	
	        	
	        	
				
			}
	        if(pq.isEmpty()) {
	        	answer[0] = 0;
	        	answer[1] = 0;
	        }
	        else { 
	        	answer[0] = pq.poll();
	        	answer[1] = pq2.poll();
	        	
	        	
	        }
	        
	        return answer;
	    }
	
	
}
