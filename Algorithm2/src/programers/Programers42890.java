package programers;

import java.util.HashSet;

public class Programers42890 {
	int answer = 0;
	HashSet<String> used_index = new HashSet<String>();

	public int solution(String[][] relation) {

		// 인덱스
		// 하나꺼내서 확인하고(set에 저장되는지 확인?)
		// contains이면 날려버리고 인덱스 저장 없으면 answer++;
		// 일단 한개씩해야되
		// 그다음 2개씩 꺼내서 index저장한게 아니면 스트링 합쳐서 set에 저장하고 확인.
		// 또 맞으면 index 저장하고.

		boolean visited[] = new boolean[relation[0].length]; // 4

		for (int i = 1; i <= relation[0].length; i++) {
			combination(relation, visited, 0, visited.length, i);
			
		}

		return used_index.size();
	}

	void combination(String[][] relation, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == true) {
					sb.append(i);
				}
			}
			// 장장 4시간에 걸친 풀이야.... 왜 안됬는지 알려줄게
			// 봐바라 04가 후보키야 그러면 04가 보함되고 더 큰 숫자가 들어간 예를들어 045, 014 는 최소성이 만족하지 않겠지?
			// 근데 잘봐 단순이 used_index에 저장된 스트링 04를 새롭게 들어오는 045에 contains하면은 되겠지 근데 014는 안되지 왜냐? 
			// 041 처럼 연속해서 있어야 가능하지 떨어져있으므로 불가능한거야 그래서 다 쪼개서 확인해봐야해.
			// 결과적으로 밑의 풀이가 나왔어;; 하.. 시발 내시간..
			for (String st : used_index) {
				
				String st2[] =st.split("");
				int count = 0;
				for (int i = 0; i < st2.length; i++) {
					//싹다 확인해서 싹다 존재하면 
					if(sb.toString().contains(st2[i])) {
						count++;
					}
				}
				if(count == st2.length) {
					return;
				}
			}

			exe(relation, visited);
			return;
		} else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(relation, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
		}
	}

	void exe(String[][] relation, boolean[] visited) {

		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < relation.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < relation[i].length; j++) {
				if (visited[j]) {
					sb.append(relation[i][j]).append(",");
				}
			}

			if (hs.contains(sb.toString())) {
				return;
			} else {
				hs.add(sb.toString());
				if (relation.length - 1 == i) {
					

					StringBuilder sb2= new StringBuilder();
					for (int j = 0; j < visited.length; j++) {
						if (visited[j]) {
							sb2.append(j);
						}
						

					}
					used_index.add(sb2.toString());

				}
			}

		}

	}

}