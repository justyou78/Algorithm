package programers;

public class Programers62048 {
	public long solution(int w, int h) {
		long answer = w * h;
		answer -= 2 * w;

		if (w == 1 || h == 1) {
			return 0;
		} else {
			int max = Math.max(w, h); //12
			int min = Math.min(w, h); //8

			int a = 0;
			int b = 0;
			for (int i = 2; i < min; i++) {
				if (min % i == 0) {
					b = i; // 최대 공약수
				}
			}
			for (int i = 2; i < max; i++) {
				if (max % i == 0 && i >= min) {
					a = i; // 최대공약수
				}
			}
			int c = a % b; // 나머지;
			int d = a + c;
			int f = (max / a) * d;

			answer = f;

		}

		return answer;
	}
}