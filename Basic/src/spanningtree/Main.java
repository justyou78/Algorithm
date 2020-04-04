package spanningtree;


import java.util.Arrays;
import java.util.Comparator;
class Main {
	/*
	 * 모든 노드를 지나면서 최소 비용을 구하는 크루스칼 알고리즘
	 * 노드를 서로 연결하는 parent배열 선언
	 * 최소비용을 기준으로 오름차순한 자체클래스 배열 생성
	 * 배열에서 하나씩 꺼내면서 부모가 다른지 확인한다.
	 * 부모가 다르면 끝점을 출발점쪽으로 연결한다.(싸이클을 방지하기 위해서)
	 * https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221230994142&proxyReferer=https%3A%2F%2Fwww.google.com%2F
	*/
 	public int solution(int n, int[][] costs) {
        int answer = 0;
        int parent[] = new int[n];
        
        for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
		}
        SpanningNode[] sn = new SpanningNode[costs.length];
        for (int i = 0; i < costs.length; i++) {
			int from = costs[i][0];
			int to= costs[i][1]; 
			int cost = costs[i][2];
			
			sn[i] = new SpanningNode(from,to,cost);
			
		}
        Arrays.sort(sn, Comparator.comparingInt(SpanningNode -> SpanningNode.cost));
        
        for (int i = 0; i < sn.length; i++) {
			int rootX = findRoot(sn[i].start,parent);
			int rootY = findRoot(sn[i].end,parent);
			
			if(rootX == rootY) continue;
			else {
				parent[rootX] = rootY;
				answer += sn[i].cost;
			}
		}
        
        
        
        return answer;
    }
	public int findRoot(int u, int parent[]) {
		if(u == parent[u] ) return u;
		else {
			parent[u] = findRoot(parent[u],parent);
			return parent[u];
		}
	}
}	

class SpanningNode{
	int start;
	int end;
	int cost;
	SpanningNode(int start, int end, int cost){
		this.start= start;
		this.end = end;
		this.cost = cost;
	}
}