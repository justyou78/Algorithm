package binarysearch;

public class Programmers43237 {
	long total = 0;

	public int solution(int[] budgets, int M) {
		int answer = 0;

		int min = 0;
		int max = 0;

		long total = 0;
		for (int i = 0; i < budgets.length; i++) {

			max = Math.max(budgets[i], max);
			total += budgets[i];

		}

		// 조건 1
		if (total <= M) {
			return max;
		}
		int mid = 0;
		while (min <= max) {

			mid = (max + min) / 2;
			if (isPossible(budgets, M, mid)) {
				answer = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}

		}

		return answer;
	}

	public boolean isPossible(int[] budgets, int M, int mid) {
		total = 0;
		for (int i = 0; i < budgets.length; i++) {
			if (budgets[i] < mid) {
				total += budgets[i];
			} else {
				total += mid;
			}

		}

		if (total <= M) {
			return true;
		} else {
			return false;
		}

	}
}