package programers;

public class BuyCookie {
	int firstSum = 0;
	int secondSum = 0;
	int answer=0;
	
	public int solution(int[] cookie) {
		int first = 0;
		int second = 0;
		boolean[] visited = new boolean[cookie.length - 1];
		for (int i = 1; i <= cookie.length - 1; i++) {
			combination(cookie, visited, 0, cookie.length - 1, i);
		}

		return answer;
	}
	public void sum(int cookie[], boolean[] visited, int n, int who) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if(visited[i]) {
				if(who == 1) {
					firstSum += cookie[i];
				}else {
					secondSum += cookie[i];
				}
			}
		}
		
		if(who ==2 && firstSum== secondSum) {
			answer = Math.max(answer, firstSum);
			
		}
		
		
	}
	public void combination2(int cookie[], boolean[] visited2, int start, int n, int r) {
		if(r==0) {
			sum(cookie,visited2,n,2);
			secondSum = 0;
			return;
		}
		else {
			for (int i = start; i < n; i++) {
				visited2[i] = true;
				combination2(cookie, visited2, i+1, n, r-1);
				visited2[i] = false;
			}
		}
	}

	public void combination(int cookie[], boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(cookie, visited, n);
			sum(cookie, visited, n,1);
			
			boolean visited2[]=  new boolean[cookie.length];
			for (int i = 1; i <= cookie.length-start; i++) {
				combination2(cookie, visited2, start, cookie.length, i);
			}
			firstSum = 0;
			return;
		}
		else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(cookie, visited, i+1, n, r-1);
				visited[i] = false;
				
			}
		}
		
		
	}
	
	 void print(int[] arr, boolean[] visited, int n) {
	     
	    	for(int i=0; i<n; i++) {
	            if(visited[i] == true)
	            {
	            	System.out.print(arr[i]);
	            
	            }
	        }
	    	System.out.println();
	   
	        
	    }
	
}
