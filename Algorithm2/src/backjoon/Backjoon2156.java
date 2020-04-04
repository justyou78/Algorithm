package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num+1];
		for (int i = 1; i <= num; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		// 6
		// 16
		// 23 13 / 23 => 235a
		// 4번째 1 2 4 /1 3 4 
		// 5번째 12 45 / 23 5
		int answer[] = new int[num+1];
		answer[1] = arr[1];
		if(num == 1) {
			System.out.println(answer[1]);
			return;
		}
		answer[2]  = arr[1]+arr[2];
		if(num== 2) {
			System.out.println(answer[2]);
			return;
		}
		
		for (int i = 3; i <= num; i++) {
			
			int t1 = Math.max(answer[i-1], arr[i]+answer[i-2]);
			answer[i] = Math.max(t1, arr[i]+arr[i-1]+answer[i-3]);
			
		}
		
		System.out.println(Math.max(answer[num], answer[num-1]));
	}
}
