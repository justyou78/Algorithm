package index;

import java.util.Arrays;

public class Programmers64062 {
	public int solution(int[] stones, int k) {
		int answer = 0;

		int cloneStones[] = stones.clone();

		int cloneK = k;

		Arrays.sort(cloneStones);
		int minus = cloneStones[cloneK - 1];
		answer = minus;
		System.out.println(answer);

		int count = 0;

		loop: while (true) {
			for (int i = 0; i < cloneStones.length; i++) {
				cloneStones[i] = cloneStones[i] - minus;
				if (cloneStones[i] <= 0) {
					count++;
					if (count == k) {
						break loop;
					}
				} else {
					count = 0;
				}
			}
			while (true) {
				if (cloneStones[++cloneK] != minus) {
					break;
				}
			}

			minus = cloneStones[cloneK] - minus;
			answer += minus;
			System.out.println(answer);

		}

		return answer;
	}
}

//k가 3이 되는 순간 넘을 수 없어.
//1 <= k <= 200000
//정렬해서 높은 숫자를 구할 수 있지  1 2 3 idx  = 3;
//일일이 -1하는건 효율 0%
//1. 
//2. 정렬해서 k만큼 빼버려 존재하는지 확인해. k+1 - k 의 값을 확인해서 디딤돌 또 빼 확인해! 