package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClimingStair {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int arr[] = new int[a + 1];
		for (int i = 1; i <= a; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[a + 1];
		dp[1] = arr[1];
		if (a >= 2)
			dp[2] = dp[1] + arr[2];
		for (int i = 3; i <= a; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]);
		}
		System.out.println(dp[a]);

	}
}
