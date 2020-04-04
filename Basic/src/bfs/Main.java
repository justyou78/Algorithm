package bfs;

public class Main {
	
	/*
	 * 시작 정점에 가까운 점들부터 탐색 멀리떨어진 정점은 나중에 방문한다.
	 * 루트노드와 직접적으로 관련된 단계부터 탐색
	 * 
	 * 큐를 이용하여 방문한 노드들을 차례로 저장하고 하나씩 꺼내여 재탐색을한다.
	 * Prim, Dijkstra 알고리즘과 유사하다.
	 * 
	 * (bfs이미지)
	 * https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
	 * 
	 * 구현과정
	 * 1. 시작노드 방문 큐에 저장 (boolean으로 체크하고 큐에 삽입)
	 * 2.큐에서 꺼낸 노드와 인접한 노드들을 모두 방문한다.(인접 노드 체크하고 큐에삽입)
	 * 3. 인접한 노드가없으면 큐에서 다시 꺼내어 2를 반복한다.
	 * 4. 큐가 소될 때까지 반복한다.
	 * 
	 * (구현 코드)
	 * https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
	 * 
	 * 시간복잡도 
	 * 인접리스트로 표현된 그래프 O(N+2)
	 * 인접 행렬로 표현된 그래프 O(N^2)
	 * 
	 * ** 스페어 그래프 : 노드보다 간선이 적은경우
	 * 이럴경우 인접리스트를 사용하는것이 유리하다.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	*/
	public static void main(String[] args) {
		
	}
	
	public void bfs() {
		
	}
	
}
