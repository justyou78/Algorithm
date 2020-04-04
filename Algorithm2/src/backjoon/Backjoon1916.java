package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon1916 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1에서 2로갈때 비용 2
		int v = Integer.parseInt(br.readLine());
		int lineCount = Integer.parseInt(br.readLine());
		int arr[][] = new int[v + 1][v + 1];

		for (int[] ar : arr) {
			Arrays.fill(ar, Integer.MAX_VALUE);
		}

		for (int i = 0; i < lineCount; i++) {
			String st[] = br.readLine().split(" ");
			int from = Integer.parseInt(st[0]);
			int to = Integer.parseInt(st[1]);
			int cost = Integer.parseInt(st[2]);
			
			arr[from][to] = arr[from][to] > cost ? cost : arr[from][to];
		}

		String st[] = br.readLine().split(" ");
		int start = Integer.parseInt(st[0]);
		int end = Integer.parseInt(st[1]);

		int answer[] = new int[v + 1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		answer[start] = 0;
		boolean visited[] = new boolean[v + 1];

		while(true){

			int min = Integer.MAX_VALUE;
			int idx = -1;

			for (int j = 1; j <= v; j++) {
				if (!visited[j] && answer[j] < min) {
					min = answer[j];
					idx = j;
				}
			}
			
			if(idx == end) {
				System.out.println(answer[idx]);
				return;
			}
			
			// 0인덱스가 잡히겠찌.
			visited[idx] = true;

			for (int i = 1; i <= v; i++) {
				// 갈 수 있는 길 , 방문하지 않은 곳,
				if (arr[idx][i] != Integer.MAX_VALUE && answer[i] > answer[idx] + arr[idx][i]) {
					answer[i] = answer[idx] + arr[idx][i];
				}
			}
		}
	}
}
