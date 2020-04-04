package programers;

public class Tiling {
	public int solution(int n) {
		int answer = 1;
		/*
		 * 피보나치 수열
		 * 
		 *
		 * 
		 * 4
		 * 3번돌겟지
		 * 
		 */
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 1; i <= n-1; i++) {
			c = a+b;
			a= b;
			b= c;
			
		}
		
		
		
		return c;
	}
}
