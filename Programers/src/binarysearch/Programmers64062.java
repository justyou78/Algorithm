package binarysearch;

import java.util.Arrays;

public class Programmers64062 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int min = 200000000;
		int max = 0;
		
		for (int i = 0; i < stones.length; i++) {
			min = Math.min(stones[i], min);
			max= Math.max(stones[i], max);
		}
		int mid = 0;
		while(min <= max) {
			mid = (max+min) /2;
			if(isPossible(stones.clone(), k, mid)) {
				answer = mid;
				min = mid+1;
			}else {
				max = mid-1;
			}
			
		}
		
		return answer;
		
		
		
		
		
		
	}
	
	public boolean isPossible(int[] cloneStones, int k, int mid) {
		for (int i = 0; i < cloneStones.length; i++) {
			int count = 0;
			cloneStones[i] = cloneStones[i] - mid;
			if(cloneStones[i] < 0) {
				count++;
				if(count >= k) {
					return false;
				}
			}else {
				count = 0;
			}
		}
		
		return true;
		
		
	}
}