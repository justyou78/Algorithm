package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Backjoon2667 {
	static int move[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	public static void main(String[] args) throws IOException {
		/*
		 * 모든 인덱스 써치
		 * 0이 아니면 dfs돌려 count값 던저주고 false를 true로
		 * true아닌  0아닌값 찾아 또 dfs돌려 conut+1 증가한걸로
		 * 이과정 하면서 arraylist에 cout값 추가해줘;
		 * 
		 * 
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		N = Integer.parseInt(st);
		int arr[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			String st2[] = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st2[j]);
				
			}
		}
		boolean check[][] = new boolean[N][N];
		int danzi = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0 && !check[i][j]) {
					danzi++;
					al.add(dfs(arr, check, danzi,i,j));
					
				}
			}
		}
		System.out.println(danzi);
		Collections.sort(al);
		for (int num : al) {
			System.out.println(num);
		}
	}
	public static int dfs(int[][] arr, boolean[][] check, int danzi, int x, int y) {
		check[x][y] = true;
		arr[x][y] = danzi;
		int count =1;
		for (int i = 0; i < 4; i++) {
			int moveX = x+move[i][0];
			int moveY = y+move[i][1];
			if(moveX >= 0  && moveX < N && moveY>=0 && moveY <N) {
				if(!check[moveX][moveY] && arr[moveX][moveY] != 0 ) {
					count +=dfs(arr,check,danzi,moveX,moveY);
					
				}
			}
		}
		return count;
	}
}