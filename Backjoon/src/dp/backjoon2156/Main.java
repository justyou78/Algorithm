package dp.backjoon2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 
		 * dp를 이용한 문제.
		 * 마지막에 결과값이 어떠한 방식으로 접근했을 때 최대값을 기질 수 있느지 생각하면서 해결하는 문제였다.
		 * 포도주를 순차적으로 3번 연속으로 먹을 수 없기때문에 이에 대한 조건
		 * 	1. n번째 포도주와 n-1번째 포도주 n-3번째 까지 먹은 최댓값
		 *  2. n번째 포도주와 n-2번째까지 먹은 최댓값
		 *  3. n-1번째 까지 먹은 포도주의 최댓값을 구하여 문제를 해결한다.
		 * 
		 * 
		*/
		int n = Integer.parseInt(br.readLine());
		int grape[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}
	
		
		int dp[] = new int[n+1];
		dp[1] = grape[1];
		
		
		if(n == 1) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = grape[1]+grape[2];
		if(n == 2) {
			System.out.println(dp[2]);
			return;
		}
		
		for (int i = 3; i <= n; i++) {
			int max = Math.max(dp[i-3]+grape[i-1]+grape[i], dp[i-1]);
			dp[i] = Math.max(max, dp[i-2]+grape[i]);
			
		}
		System.out.println(Math.max(dp[n], dp[n-1]));
		
	}
}
