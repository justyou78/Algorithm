package Greeedy;

import java.util.Arrays;

public class Programmers42886 {
	public int solution(int[] weight) {
		int answer = 0;

		Arrays.sort(weight);
		int sum = 1;
		if (weight[0] > sum) {
			return sum;
		}

		for (int i = 0; i < weight.length; i++) {
			if (sum >= weight[i]) {
				sum += weight[i];
			} else {
				return weight[i] + 1;
			}

		}

		return sum;

	}
}
