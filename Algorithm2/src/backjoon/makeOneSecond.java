package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class makeOneSecond {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();

		hs.add(num);
		int count = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		if(num == 1) {
			System.out.println(0);
			return;
		}
		
		
		while (true) {
			count++;
			Iterator<Integer> it = hs.iterator();
			while (it.hasNext()) {
				int num2 = it.next();

				int a = devideThree(num2);
				int b = devideTwo(num2);
				int c = minusOne(num2);
				if (a == 1) {
					System.out.println(count);
					
					return;
				}
				if (b == 1) {
					System.out.println(count);
					
					
					return;
				}
				if (c == 1) {
				
					System.out.println(count);
				
					return;
				}
				if(a != num2) {
					al.add(a);
				}
				if(b != num2) {
					al.add(b);
				}
				al.add(c);
				
				al2.add(num2);
			}
			
			for (int getNum : al2) {
				hs.remove(getNum);
			}
			for (int getNum : al) {
				hs.add(getNum);
			}
		}

	}

	public static int devideThree(int num) {
		if (num % 3 == 0)
			return (int) num / 3;
		return num;
	}

	public static int devideTwo(int num) {
		if (num % 2 == 0)
			return (int) num / 2;
		return num;
	}

	public static int minusOne(int num) {
		return num - 1;
	}

}
