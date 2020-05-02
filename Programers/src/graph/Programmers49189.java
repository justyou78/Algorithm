package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers49189 {
	public int solution(int n, int[][] edge) {
		/*
		 * 50000 20000 * 200000 50000번 조회 간선이 많으면 배열이 좋겟지 ? 배열에 답고 큐 이용 클래스 객체 깊이랑 값
		 * 
		 * 
		 */

		boolean arr[][] = new boolean[n+1][n+1];
		Queue<Node> queue = new LinkedList<Node>();
		
		for (int i = 0; i < edge.length; i++) {
			int start = edge[i][0];
			int end = edge[i][1];

			arr[start][end] = true;
			arr[end][start] = true;

		}
		
		
		
		queue.offer(new Node(1, 1));
		
		
		boolean check[] = new boolean[n+1];
		check[1] = true;
		
		int total = 0;
		
		int idx = 0;
		while(!queue.isEmpty()) {
			Node getNode = queue.poll();
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if(!check[j] && arr[j][getNode.num])
				{
					count++;
					check[j] = true;
					queue.add(new Node(getNode.depth+1, j));
				}
			}
			
			
			if(idx != getNode.depth ) {
				if(count != 0) {
					total = count;
					idx = getNode.depth;
				}
				
			}
			else {
				total += count;
			}
		}
		
		return total;

	}
}

class Node{
	int depth;
	int num;
	public Node(int depth, int num) {
		this.depth = depth;
		this.num = num;
	}
	
	
}
