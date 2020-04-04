package study;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> al = new  ArrayList<Integer>();
		al.add(0, 1);
		al.add(0, 2);
		al.add(0, 3);
		al.add(0, 4);
		
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}
}
