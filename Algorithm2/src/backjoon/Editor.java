package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Editor {
	public String exe() throws IOException {
		String answer = "";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split("");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(st));
		
		
		
		
		int count = Integer.parseInt(br.readLine());
		
		int cursor_index = list.size();
		for (int i = 0; i < count; i++) {

			String c = br.readLine();
			System.out.println(c);
//			if (c.equals("L")) {
//				cursor_index--;
//			} else if (c.equals("D")) {
//				if (cursor_index < list.size()) {
//					cursor_index++;
//				}
//
//			} else if (c.equals("B")) {
//				list.remove(cursor_index-1);
//				cursor_index--;
//
//			} else if (c.indexOf("P") == 0) {
//				char plus = c.charAt(2);
//				list.add(cursor_index,String.valueOf(plus));
//				cursor_index++;
//				
//			}

		}
//		for (int i = 0; i < list.size(); i++) {
//			answer+= list.get(i);
//		}
		return answer;
	}
}
