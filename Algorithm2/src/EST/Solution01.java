package EST;

import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
    	
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < A.length; i++) {
			if(!hm.containsKey(A[i])) {
				hm.put(A[i], 1);
			}
			else {
				hm.replace(A[i], hm.get(A[i])+1);
			}
		}
    	int answer = 0;
    	for (int key : hm.keySet()) {
			if(key == hm.get(key)) {
				answer = Math.max(key, answer);
			}
		}
    	
    	return answer;
    }
}
