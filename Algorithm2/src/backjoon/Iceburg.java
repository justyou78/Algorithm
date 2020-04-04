package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Iceburg {
	static int move[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N;
	static int M = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * 처음에 덩어리가 몇개있는지 확인해야겠지 ? 배열쭉가면서 boolean true로 만들어주고 두번째에서 0이 아니면서 false인게 있으면
		 * return answer; 아니잖아 ? 그러면 answer++ 하면서 상하좌우 확인하면서 0인값 확인해서 줄여주자
		 * 
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String st2[] = br.readLine().split(" ");
			for (int j = 0; j < st2.length; j++) {
				arr[i][j] = Integer.parseInt(st2[j]);
			}
		}
		
		int answer = 0;

		while(true) {
			int count = 0;
			boolean[][] check = new boolean[N][M];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] != 0 && check[i][j] == false) {
						count++;
						if (count == 2) {
							System.out.println(answer);
							return;
						}
						dfs(arr, check, i, j);
					}
				}
			}
			if(count ==0) {
				System.out.println(0);
				return;
			}
			arr =afterYear(arr);
			answer++;

		}

	}

	public static int[][] afterYear(int[][] arr) {
		int[][] cloneArr = new int[N][M];
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					int count = 0;
					for (int j2 = 0; j2 < 4; j2++) {
						int moveX = i + move[j2][0];
						int moveY = j + move[j2][1];
						
						if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
							if (arr[moveX][moveY] == 0) {
								count++;
							}
						}
					}
					cloneArr[i][j] = arr[i][j] - count < 0 ? 0 : arr[i][j] - count;
				}
			}
		}
		return cloneArr;
	}

	public static void dfs(int[][] arr, boolean[][] check, int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int moveX = x + move[i][0];
			int moveY = y + move[i][1];

			if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
				if (arr[moveX][moveY] != 0 && !check[moveX][moveY]) {
					dfs(arr, check, moveX, moveY);
				}
			}
		}
	}
}