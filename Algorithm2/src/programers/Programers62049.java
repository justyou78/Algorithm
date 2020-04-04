package programers;

import java.util.Arrays;

public class Programers62049 {
	public int[] solution(int n) {
		int[] answer = new int[(int) Math.pow(2, n - 1) + 1];
		if (n == 1) {
			int arr[] = { 0 };
			return arr;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		for (int i = 2; i <= n; i++) {
			int index = 0;
			for (int j = 0; j < (int) Math.pow(2, i-1); j++) {
				String st ="";
				if(j%2 ==0) {
					st="0";
				}
				else {
					st="1";
				}
				sb.append(st,index,1);
				index += 2;
			}
		}
		answer =Arrays.stream(sb.toString().split("")).mapToInt(Integer::parseInt).toArray();
		return answer;
	}
}
//1 3 7  8개
// 2*0+1 / 2*1+1 / 2*3+1 / 15
// 한번 접으면서 가운데 0;
// 2 -> 0인덱스 좌우 
// 두번저으면서 0 0 1 끝을 기준으로 4개 
// 3 -> 0, 2인덱스 좌우
// 세번 접으면서 0 0 1 0 0 1 1 
// 4-> 0, 2, 4, 6
// 네번  -> 15 / 0 0 1 0 0 1 1 0 0 1 1 1 0 1 1
