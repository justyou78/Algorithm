package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Combination {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		long n = Long.parseLong(st[0]);
		long r = Long.parseLong(st[1]);
		BigInteger  num =  BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		if((n-r) < r){
			r = n-r;
		}
		
		for (int i = 0; i < r; i++) {
			num =num.multiply(BigInteger.valueOf(n-i));
			num2 =num2.multiply(BigInteger.valueOf(i+1));
		}
		num = num.divide(num2);
		
		System.out.println(num);
	}
}
