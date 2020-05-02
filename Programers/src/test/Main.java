package test;

import java.util.Arrays;
import java.util.Stack;

public class Main {
	public int solution(String name) {
		int answer = 0;
		// 26
		for (int i = 0; i < name.length(); i++) {
			char spell = name.charAt(i);

			if (spell != 'A') {
				answer += Math.min('Z' - spell, Math.abs('A' - spell));
			}

		}

		return answer;
	}

	public int leftCount(String name, int idx) {
		int count = 0;
		while(true) {
			for (int i = 0; i < name.length(); i++) {
				if(idx-1 == 0) {
					idx = name.length()-1;
				}
				else {
					idx--;
				}
				if(name.charAt(idx) == 'A') {
					count++;
				}
				else {
					
				}
				
			}
		}
	}

	public int rightCount(String name) {

	}
}