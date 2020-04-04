package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Delivery {
	public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int dist[][] =new int[n][n];
        
        for (int i = 0; i < costs.length; i++) {
			int from = costs[i][0];
			int to= costs[i][1];
			int cost = costs[i][2];
			
			dist[from][to] = cost;
			dist[to][from] = cost;
			
		}
        
        
        
        return answer;
    }
}	

class SpanningNode{
	int start;
	int end;
	int cost;
	SpanningNode(int start, int end, int cost){
		this.start= start;
		this.end = end;
	}
}