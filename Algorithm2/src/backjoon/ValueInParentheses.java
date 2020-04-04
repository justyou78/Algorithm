package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ValueInParentheses {
	public int exe() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split("");
		Queue<String> queue= new LinkedList<String>();
		int answer = 0;
	
		String before ="";
		for (int i = 0; i < st.length; i++) {
			String s = st[i];
			if(s.equals("(") || s.equals("[")) {
				queue.add(s);
			}
			else if(s.equals("]")) {
				if(!queue.isEmpty()) {
					String get = queue.poll();
					if(get.equals("[")) {
						if(before.equals(")") || before.equals("]")) {
							answer *= 3;
						}else {
							answer +=3;
						}
					}
					else {
						return 0;
					}
				}
				else {
					return 0;
				}
			}
			else if(s.equals(")")){
				
				if(!queue.isEmpty()) {
					String get = queue.poll();
					if(get.equals(")")) {
						if(before.equals(")") || before.equals("]")) {
							answer *= 2;
						}else {
							answer +=2;
						}
					}
					else {
						return 0;
					}
				}
				else {
					return 0;
				}
				
			}
			
			before = s;
			
			
			
		}
		return answer;
		
	}
}

//2 
