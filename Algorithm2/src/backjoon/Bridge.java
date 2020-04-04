package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge {
	static int move[][]= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int [][]arr = new int[num][num];
		for (int i = 0; i < num; i++) {
			String []st = br.readLine().split(" ");
			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		boolean check[][]= new boolean[num][num];
		int num2 = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] !=0 && !check[i][j])
				{
					dfs(arr, check,num2, i,j);
					num2++;
				}
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) continue;
				for (int j2 = 0; j2 < arr.length; j2++) {
					for (int k = 0; k < arr[j2].length; k++) {
						if(arr[j2][k] !=0 &&arr[j2][k] != arr[i][j] ) {
							int distance = Math.max(i, j2)-Math.min(i,j2) + Math.max(j, k) -  Math.min(j, k);							
							distance  =Math.abs(distance)-1;
							min = Math.min(min, distance);
						}
					}
				}
				
			}
		}
		System.out.println(min);
		
		
		
		
		
		
		
		
	}
	
	public static void dfs(int [][]arr, boolean check[][],int  num2, int x, int y) {
		check[x][y] = true;
		arr[x][y] = num2;
		for (int i = 0; i < 4; i++) {
			int moveX = x+move[i][0];
			int moveY = y+move[i][1];
			if(moveX >= 0 && moveX < arr.length && moveY >= 0 && moveY < arr.length) {
				if(arr[moveX][moveY] != 0 && !check[moveX][moveY]) {
					dfs(arr,check,num2,moveX,moveY);
				}
			}
		}
	}
}
