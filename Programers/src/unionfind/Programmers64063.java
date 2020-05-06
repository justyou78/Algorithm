package unionfind;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers64063 {
	  public long[] solution(long k, long[] room_number) {
          
	        long[] answer = new long[room_number.length];
	       
	        HashMap<Long, Long> hm = new HashMap<Long, Long>();
	        
	        for (int i = 0; i < room_number.length; i++) {
				if(!hm.containsKey(room_number[i]))
				{
                  
					hm.put(room_number[i], room_number[i]+1);
					answer[i] = room_number[i];
					
				}
				else {
					long parent = hm.get(room_number[i]);
					ArrayList<Long> al = new ArrayList<Long>();
					al.add(room_number[i]);
					while(true) {
						
						if(!hm.containsKey(parent)) {
							hm.put(parent, parent+1);
							answer[i] = parent;
							
							for (int j = 0; j < al.size(); j++) {
								hm.put(al.get(j), parent+1);
							}
							break;
						}
						else {
							al.add(parent);
							parent=hm.get(parent);
						}
					}
				}
			}
	        
	        return answer;
	    }
	}