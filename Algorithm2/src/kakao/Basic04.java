package kakao;

import java.util.Collections;
import java.util.PriorityQueue;

public class Basic04 {
	 public long solution(int n, int[] works) {
	        long answer = 0;
	        
	        //우선수위 큐를 사용했어
	        //이유 ? => 동적으로 큐 에 저장된 내용이 내림차순으로 정렬되어야 하기 때문이었지.
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	        //큐에 데이터 삽입
	        for (int i = 0; i < works.length; i++) {
				pq.add(works[i]);
			}
	        // n 만큼 큐에 저장된 가장 큰 값을 줄여주는 과정.
	        for (int i = 0; i <n; i++) {
	        	// 큐에 데이터가 없는데 포문을 돌리면  NullPointerExeption이 발생해. 
	        	// 왜냐 ? number = pq.poll(); 에서 number에 널값이 들어가기 때문이겠지.,
	        	if(pq.isEmpty()) {
	        		break;
	        	}
				int number = pq.poll();
				number--;
				// 데이터가 0이면  queue에 저장하지 않을거야 
				if(number == 0) {
					continue;
				}
				pq.add(number);
				
			}
	        //제곱해서 answer에 내용을 더하고 출력하는 과정.
	        while(!pq.isEmpty())
	        {
	        	int number = pq.poll();
	        	answer += Math.pow(number, 2);
	        }
	        return answer;
	    }
}
