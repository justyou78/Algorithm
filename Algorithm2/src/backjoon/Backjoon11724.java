package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11724 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		/*
		 * 
		 *  행렬에 다 짚어 넣어주자
		 *  그리고 1번부터 쭉~ 확인하면서 false인값 있으면 dfs돌려주고 카운트 증가
		 *  
		 *  
		*/
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M= Integer.parseInt(st[1]);
		int arr[][] = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			String st2[] = br.readLine().split(" ");
			int from = Integer.parseInt(st2[0]);
			int to= Integer.parseInt(st2[1]);
			
			arr[from][to] = 1;
			arr[to][from] = 1;
			
			
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(arr[i][j]);
//				
//			}
//			System.out.println();
//		}
		
		boolean check[] = new boolean[N+1];
		int count =0;
		for (int i = 1; i <= N; i++) {
				if(!check[i]) {
					dfs(i,check, arr);
					count++;
				}
		}
		System.out.println(count);
		
		
		
		
	}
	public static void dfs(int n,boolean check[], int arr[][] ) {
		for (int i = 1; i <= N; i++) {
			if(arr[n][i] == 1 && !check[i]   ) {
				check[i] = true;
				dfs(i, check,  arr);
			}
		}
	}
}