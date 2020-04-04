package FA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//두 문자열 비교
public class Backjoon1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String st[] = br.readLine().split(" ");
		String a = st[0];
		String b = st[1];
		
		//aab abadfsa
		int min = Integer.MAX_VALUE;
		int gap=b.length()-a.length();
		for (int i = 0; i <= gap; i++) {
			int count = 0;
			for (int j = 0; j < a.length(); j++) {
				if(a.charAt(j)!=b.charAt(j+i)) {
					count++;
				}
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
		
	}
}
