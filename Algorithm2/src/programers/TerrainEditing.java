package programers;

public class TerrainEditing {
	public long solution(int[][] land, int P, int Q) {
		long answer = Long.MAX_VALUE;
		/*
		 * 모두가 +이면 break;
		 * 0부터 시작해서 10억까지 for문
		 * i위치로 각 블록 변경
		 * 값 구하고 answer과 비교 작은값 리턴
		 * 카운트 변수가 land.length*2 와 같아지면 빠져나오기.
		 * 
		 * 
		
		*/
		
		
		for (int i = 0; i <= 1000000000; i++) {
			long max = 0;
			int count = 0;
			for (int j = 0; j < land.length; j++) {
				for (int j2 = 0; j2 < land.length; j2++) {
					if(land[j][j2] >i) {
						
						int num = land[j][j2];
						while(num > i) {
							max += Q;
							num--;
						}
					}
					else if(land[j][j2] < i) {
						count++;
						int num = land[j][j2];
						while(num < i) {
							max += P;
							num++;
						}
					}
				}
			}
			if(count == Math.pow(land.length, 2)) {
				break;
			}
			if(answer > max) {
				answer = max;
			}
			else {
				break;
			}
			
			
		}
		
		return answer;
	}
}

