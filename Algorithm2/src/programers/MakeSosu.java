package programers;

public class MakeSosu {
	int answer = 0;
	//백트래킹 보다는 for문이 더빠르네
	public int solution(int[] nums) {

		/*
		 * 콤비네이션으로 3개값 가져오기. 다 더하고 소수인지 확인.
		 * 
		 * 
		 */

		boolean check[] = new boolean[nums.length];
		combination(nums, check, 0, nums.length, 3);

		

		return answer;
	}

	public void combination(int[] nums, boolean[] check, int start, int n, int r) {
		if (r == 0) {
			findSoSu(nums, check, n);
		}

		for (int i = start; i < n; i++) {
			check[i] = true;
			combination(nums, check, i + 1, n, r - 1);
			check[i] = false;
		}
	}

	public void findSoSu(int[] nums, boolean[] check, int n) {
		int isSosu = 0;
		for (int i = 0; i < n; i++) {
			if (check[i]) isSosu+= nums[i];
		}
		
		int num = isSosu/2;
		for (int i = 2; i < num; i++) {
			if(isSosu%i == 0) {
				return;
			}
		}
		answer ++;
	}

}
