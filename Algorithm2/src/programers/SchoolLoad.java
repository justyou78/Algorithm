package programers;

public class SchoolLoad {
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		/*
		 * 다 0 으로 초기화하고 puddles쪽 true 불린 설정 좌표 쭉가면서 상좌 살피며서 값 넣어 return 마지막 좌표
		 * 
		 * 
		 */
		int arr[][] = new int[n][m];
		arr[0][0] = 1;
		boolean check[][] = new boolean[n][m];
		for (int i = 0; i < puddles.length; i++) {
			check[puddles[i][0]-1][puddles[i][1]-1] = true;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int num = 0;
				if (i == 0 && j == 0)
					continue;
				// 위쪽확인
				if (i - 1 >= 0) {
					if (!check[i - 1][j]) {
						num += arr[i - 1][j];
					}
				}
				// 왼쪽확인
				if (j - 1 >= 0) {
					if (!check[i][j - 1]) {
						num += arr[i][j - 1];
					}
				}
				arr[i][j] = num % 1000000007;
			}
		}

		

		return arr[n - 1][m - 1] % 1000000007;
	}
}