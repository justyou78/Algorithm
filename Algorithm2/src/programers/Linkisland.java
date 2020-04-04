package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Linkisland {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		/*
		 * 
		 * 무조건 0부터 시작 0 에서 갈수잇는 1과 2를 최소경로인지 확인하고 이동해 큐에 집어넣어 1과 2를 최소경로라면 1의 입장에서 0을제외한
		 * 3과 2로가는 것중에 최소경로가 되는것 구해 3 큐에넣어 2에서 최소경로 갈수잇는데 ? 업서 끝
		 * 
		 * 
		 * 
		 * 
		 */
		int dist[][] = new int[n][n];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			
		}
		
		for (int i = 0; i < costs.length; i++) {
			int from = costs[i][0];
			int to = costs[i][1];
			int val = costs[i][2];

			dist[from][to] = val;
			dist[to][from] = val;

		}
		int val[] = new int[n];
		Arrays.fill(val, Integer.MAX_VALUE);
		boolean check[] = new boolean[n];

		check[0] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int i = 0; i < n; i++) {
				if (!check[i] && dist[node][i] <val[i]) {
					val[i] = dist[node][i];
					check[i] = true;
					queue.add(i);
				}
			}

		}
		for (int i = 1; i < n; i++) {
			answer += val[i];
		}

		return answer;
	}
}