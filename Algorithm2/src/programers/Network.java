package programers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		/*
		 * bfs로 만들어보자 큐에 내용 담으면서 쭉 집어넣어 boolean값을 true로 변경해 큐가 비워지면 n만큼 돌리면 다른 집단 만들어
		 * answer++해줘야겟지 ?
		 * 
		 */
		boolean check[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			if (!check[i]) {
				queue.add(i);
				check[i] = true;
				answer++;
			}
			while (!queue.isEmpty()) {
				int num = queue.poll();
				for (int j = 0; j < computers[num].length; j++) {
					if(num ==j) continue;
					if(computers[num][j] == 1 && !check[j]) {
						queue.add(j);
						check[j] = true;
					}
				}
			}
		}

		return answer;
	}
}