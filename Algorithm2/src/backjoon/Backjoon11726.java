package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//1 1
		//2 2 1개증가
		//3 3 
		//4 5 1개증가
		//6 
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int a = 1;
		int b=2;
		int c = 0;
		if( num == 1 ) {
			System.out.println(a);
			return;
		}
		if(num ==2 ) {
			System.out.println(b);
			return;
		}
		for (int i = 3; i <= num; i++) {
			c = a+b;
			
			a= b %10007;
			b= c %10007;
			
		}
		System.out.println(c%10007);
	}
}
