package kakao2020;

public class String_compressionSolution {

	public int solution(String s) {

		int answer = s.length();
		/*
		 * 
		 * for문 글자의 갯수 for문 글자의 길이만큼 -> 범위가 글자의 길이보다 커진다면 이어붙인다. ->같으면 count증가 ->다르면
		 * 문자열에 추가하고 ->for문끝나면 비교해서 작은값만 계산한다!
		 * 
		 * 
		 */
		for (int i = 1; i <= s.length() / 2; i++) {
			int result = getShortLength(s, i, 1).length();
			answer = i == 1 ? result : (answer > result ? result : answer);
		}

		return answer;

	}

	public String getShortLength(String s, int n, int repeat) {
		if (s.length() < n)
			return s;

		String result = "";
		String preString = s.substring(0, n);
		String postString = s.substring(n, s.length());

		if (!postString.startsWith(preString)) {
			if (repeat == 1)
				return result += preString + getShortLength(postString, n, 1);
			return result += Integer.toString(repeat) + preString + getShortLength(postString, n, 1);
		}

		return result += getShortLength(postString, n, repeat + 1);

	}

}
