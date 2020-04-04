package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Order02 {
	/*
	 * 힙 정렬
	
	*/
	public void exe() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) {
			al.add( Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}
