package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2193{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//1 1
		//2 2 1개증가
		//3 3 
		//4 5 1개증가
		//6 
		//피보나치는 46항에서 2971215073이 된다.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		long a = 1;
		long b=1;
		long c = 0;
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
			
			a= b ;
			b= c ;
			
		}
		System.out.println(c);
	}
}
