package programers;

import java.util.ArrayList;

public class MakeStation {
	public int solution(int n, int[] stations, int w) {
		/*
		 * 
		 * 시작점과 끝점을 찾아. 이미 설치되어있는 곳 처음 start 를 0으로 잡고 arrayList에서 하나꺼내 start와 0 사이를 나눈값과
		 * 나머지값을 answer에 추가 start는 end값으로 변경 이과정 반복
		 * 
		 */
		int answer = 0;
		ArrayList<int[]> al = new ArrayList<int[]>();
		for (int i = 0; i < stations.length; i++) {
			int index = stations[i];
			int start = 1;
			int end = n;
			for (int j = index - w; j  <= index; j++) {
				if (j >= 1) {
					start = j;
					break;
				}
			}
			for (int j = index + w; j >= index ; j--) {
				if (j <= n) {
					end = j;
					break;
				}

			}
			int arr[] = {start,end};
			al.add(arr);
		}
		
		
		int start = 1;
		int end = n;
		int cal = w*2+1;
		for (int arr[] : al) {
			end = arr[0];
			
			int num=end-start;
			if(num >0) {
				answer += num/cal;
				if(num%cal > 0) {
					answer++;
				}
			}
			start = arr[1]+1;
		}
		
		int num=n-start;
		if(num >0) {
			answer += num/cal;
			if(num%cal > 0) {
				answer++;
			}
		}
		
		return answer;
		
		
	}

}
