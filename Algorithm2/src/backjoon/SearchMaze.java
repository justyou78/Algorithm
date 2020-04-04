package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//public class SearchMaze {
//	static int move[][] = { {1,0},{0,1},{-1,0},{0,-1}};
//	static int N;
//	static int M;
//	
//	public static void main(String[] args) throws IOException {
//		/*
//		 * 
//		 * bfs => n ,m까지 count세주고
//		
//		*/
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String st[] = br.readLine().split(" ");
//		N = Integer.parseInt(st[0]);
//		M = Integer.parseInt(st[1]);
//		int [][]arr = new int[N+1][M+1];
//		for (int i = 1; i <= N; i++) {
//			String st2[] = br.readLine().split("");
//			for (int j = 1; j <= M; j++) {
//				arr[i][j] = Integer.parseInt(st2[j-1]);
//			}
//		}
//		boolean check[][] = new boolean[N+1][M+1];
//		Queue<Spot> queue= new LinkedList<Spot>();
//		queue.add(new Spot(1, 1));
//		
//		while(!queue.isEmpty())
//		{
//			Spot node = queue.poll();
//			
//			int x = node.x;
//			int y = node.y;
//			check[x][y] =true;
//			
//			if(x == N && y == M) {
//				System.out.println(arr[x][y]);
//				return;
//			}
//			for (int i = 0; i < 4; i++) {
//				int moveX = x+move[i][0];
//				int moveY = y+move[i][1];
//				
//				if(moveX >= 1 && moveX <=N && moveY >= 1 && moveY <= M) {
//					if(arr[moveX][moveY] == 1 && !check[moveX][moveY])
//					{
//						
//						queue.add(new Spot(moveX, moveY));
//						arr[moveX][moveY] +=arr[x][y];
//					}
//					
//				}
//			}	
//		}
//	}
//}
//
//class Spot{
//	int x;
//	int y;
//
//	Spot(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
