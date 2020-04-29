package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 
		 * unionfind 배열에 각 index로 초기화한다.
		 * find메서드 생성 및 구현
		 * union 메서드 생성 및 구현
		 * 입력받은 값을 union처리하며 각각의 합집합 생성
		 * unionfind배열에 합집합 구성.
		 * 
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			
			String st[] = br.readLine().split(" ");
			int g1 = Integer.parseInt(st[0]);
			int g2 = Integer.parseInt(st[1]);
			arr[i][0] = g1;
			arr[i][1] = g2;
			
			
		}
		
		int unionfind[] = new int[num];
		for (int i = 0; i < unionfind.length; i++) {
			unionfind[i] = i;
		}
		
		for (int i = 0; i < num; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1] + " test");
			union(arr[i][0],arr[i][1], unionfind);
			
			
		}
		

		for (int i = 0; i < unionfind.length; i++) {
			System.out.println(unionfind[i]);
		}
		
	}
	
	
	public static int find(int x, int unionfind[]) {
		
		if(unionfind[x] == x) {
			return x;
		}
		else {
			return unionfind[x] = find(unionfind[x], unionfind);
		}
		
	}
	
	public static void union(int x, int y, int unionfind[]) {
		x = find(x,unionfind);
		y= find(y,unionfind);
		if(x != y) {
			if(x  < y) unionfind[y] = x;
			else unionfind[x] =y;
		}
	}
	
}
