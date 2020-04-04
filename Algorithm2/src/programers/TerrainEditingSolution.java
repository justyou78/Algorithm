package programers;

public class TerrainEditingSolution {
	public long solution(int[][] land, int P, int Q) {
		long answer = -1;
		/*
		 * middle값을 찾고 => 90000번 더하기(효율성)
		 * 미들값을 기준으로 최소비용 구하기.
		 * 좌측과 우측으로 이동한다.
		 * middle-1 과 middle+1에 대한 값을 구한다.
		 * 만약 미들값의 비용보다 작은 비용이라면 그쪽으로 이동 아니라면 멈추기.
		 * 
		 *
		*/
		long middle = 0;
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land.length; j++) {
				middle += land[i][j];
			}
		}
		//2
		middle  = (long) (middle / Math.pow(land.length, 2));
		//2
		long middle2 = middle;
		// 5
		long cost = findCost(land, middle,P,Q);
		// 5
		long cost3 = cost;
		
		while(middle < 1000000000) {
			//33
			long cost2 = findCost(land, middle+1, P, Q);
			if(cost < cost2) {
				break;
			}
			else {
				cost = cost2;
				middle++;
			}
		}
		//cost = 5
		
		while(middle2 > 0) {
			long cost2 = findCost(land, middle2-1, P, Q);
			if(cost3 < cost2) {
				break;
			}
			else {
				cost3 = cost2;
				middle2--;
			}
		}
		answer =Math.min(cost, cost3);
		
		
		
		
		
		return answer;
	}
	
	public long findCost(int[][] land, long height,int P, int Q) {
		System.out.println(height);
		long val = 0;
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land.length; j++) {
				if(land[i][j] < height) {
					int num = land[i][j];
					while(num < height) {
						val += P;
						num++;
					}
				}
				else if(land[i][j] > height) {
					int num = land[i][j];
					while(num > height) {
						val += Q;
						num--;
					}
				}
				
			}
		}
		System.out.println(val);
		return val;
	}
}
