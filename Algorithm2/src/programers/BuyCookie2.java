package programers;

public class BuyCookie2 {
	int answer = 0;
	public int solution(int[] cookie) {
		
		exe(cookie,0,1,0);

		return answer;
	}
	
	public void exe(int cookie[], int index, int depth, int beforeSum) {
		
		for (int i = 1; i <= cookie.length; i++) {
			for (int j = index; j < cookie.length; j++) {
				int firstCookie = 0;
				if (i + j > cookie.length) {
					break;
				} else {
					for (int j2 = j; j2 < j + i; j2++) {
						firstCookie += cookie[j2];
					}
					if(depth == 2 && beforeSum > 0) {
						check(beforeSum,firstCookie);
					}
					else {
						exe(cookie, j+1, depth+1,firstCookie);
					}
					System.out.println(depth+"깊이 "+beforeSum + firstCookie);
				}
			}
		}
	}
	public void check(int a, int b)
	{
		if(a == b) {
			System.out.println(a);
			answer = Math.max(answer, a);
		}
	}
}
