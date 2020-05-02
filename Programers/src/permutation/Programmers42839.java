package permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Programmers42839 {
	HashSet<Integer> hs= new HashSet<Integer>();
	public int solution(String numbers) {
		int answer = 0;

		
		boolean check[] = new boolean[numbers.length()];
		ArrayList<String> al = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < numbers.length(); i++) {
			permutation(check, numbers, numbers.length(), i+1, stack);
		}
		
		
		return hs.size();
	}
	public void permutation(boolean[] check, String numbers, int n, int r, Stack<String> stack) {
		if(r == 0)
		{
			checkSoSu(stack);
			
			return;
			
		}
		
		
		
		for (int i = 0; i < n; i++) {
			if(!check[i]) {
				stack.push(String.valueOf(numbers.charAt(i)));
				check[i] =  true;
				permutation(check, numbers, n, r-1, stack);
				stack.pop();
				check[i] = false;
			}
		}
		
		
	}
	
	private void checkSoSu(Stack<String> stack) {
		
		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		int num = Integer.parseInt(sb.toString());
		System.out.println(num);
		if(num == 1) {
			hs.add(num);
		}
		
		
		for (int i = 2; i < num/2; i++) {
			if(num % 2== 0) {
				hs.add(num);
				break;
			}
		}
		
	}
}
