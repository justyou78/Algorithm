package FA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

//행복의 문자열 
public class Backjoon1342 {
	static int answer = 0;
	static HashSet<String> hs = new HashSet<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		Stack<Character> s = new Stack<Character>();
		boolean visited[] = new boolean[st.length()];
		permutation(st, s, visited, st.length(), st.length());
		int al[] = new int[26];
		for (int i = 0; i < st.length(); i++) {
			al[st.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < al.length; i++) {
			System.out.print(al[i]);
		}
		System.out.println();
		System.out.println(answer);
		
		for (int i = 0; i < al.length; i++) {
			if(al[i] > 1) {
				answer /=factorial(al[i]);
			}
		}

		System.out.println(answer);
	}
	public static int factorial(int N) {
        if(N==1)
            return 1;
        
        return N*factorial(N-1);
    }
	// abcdefghi -> 10!
	// aab -> aab aba aab aba baa baa => 2개;
	// 총 개수 6개 중복되는 갯수 2 2 2 일치하는 경우 2개

	public static void permutation(String st, Stack<Character> s, boolean visited[], int n, int r) {
		if (r == 0) {
			answer++;
		} else {
			for (int i = 0; i < st.length(); i++) {
				if (!visited[i] && (s.isEmpty() || s.lastElement() != st.charAt(i))) {
					visited[i] = true;
					s.push(st.charAt(i));
					permutation(st, s, visited, n, r - 1);
					visited[i] = false;
					s.pop();
				}
			}

		}
	}

	
}
