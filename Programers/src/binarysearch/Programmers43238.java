package binarysearch;

public class Programmers43238 {
	public long solution(int n, int[] times) {
		long answer = 0;

		long min = 10000000000L;
		long max = 0;
		for (int i = 0; i < times.length; i++) {
			min = Math.min(times[i], min);
			max = Math.max(times[i], max);

		}
		max = max * (long)n;
		long mid = 0;
		while (min <= max) {

			mid = (max+min)/2;
			
			if(isPossible(n, times, mid)) {
				answer = mid;
				max= mid-1;
			}
			else {
				min = mid+1;
			}
			
		}

		return answer;

		// 보통은 타이머를 설정해서 증가시키면서 n이 0이 될때까지 돌리겠지.
		// 사람이 10억명이고, 심사관이 10만명이니까..... 너무 오래걸리겟지.
		// 1 <= times <= 1000000000
		// 10분 10* 60 => 600분 => 610 => 305

	}

	private boolean isPossible(int n, int[] times, long mid) {
		int total = 0;
		for (int i = 0; i < times.length; i++) {
			
			total += mid/times[i];
			if(total >= n) {
				return true;
			}
		}
		
		return false;
		
		
	}
}
