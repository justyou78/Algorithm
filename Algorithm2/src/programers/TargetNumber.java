package programers;

public class TargetNumber {
	int answer = 0;

	public int solution(int[] numbers, int target) {

		/*
		 * numbers의 길이만큼 재귀함수를 돌려주자. 깊이끝에 도달하면 target넘버와 일치하는지 확인하고 일치하면 정답을 증가시키자.
		 * 
		 * 
		 */
		dfs(0,0,numbers,target);
		
		return answer;
	}

	public void dfs(int sum, int depth,  int arr[], int target) {
		if (depth == arr.length) {
			if (sum == target) {
				answer++;
				
			}
			return;
		} else {
			dfs(sum+arr[depth], depth+1,arr,target);
			dfs(sum-arr[depth], depth+1, arr,target);
		}
	}

}