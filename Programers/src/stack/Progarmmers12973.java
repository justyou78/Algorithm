package stack;

import java.util.Stack;

public class Progarmmers12973 {
	public int solution(String s) {

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty()) {
				st.push(s.charAt(i));

			} else {
				if (st.peek() == s.charAt(i)) {
					st.pop();
				}

			}
		}
		if (st.isEmpty())
			return 1;

		else
			return 0;

	}
}
