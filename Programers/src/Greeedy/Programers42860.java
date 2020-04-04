package Greeedy;

import java.util.LinkedList;
import java.util.Queue;

public class Programers42860 {
	public int solution(String name) {
		/*
		 * 첫번째로 인덱스에 위치한 알파벳을 변경시키는 과정이 필요해.
		 * 두번째로는 그 인덱스에서 좌우측으로 이동하면서 가장가까운 A가아닌 알파벳을 찾아가는
		 * 과정이 필요해.
		 * 코드를 한번 갈아엎은 이유는 A에 의해서 인덱스가 0이나 len만큼 이동하게되면 순환하여 반대의 인덱스 알파벳을
		 * 확인하는 과정을 생각했어야 했어.
		 * 두번째로 어려웠던 것은 가장가까운 인덱스의 알파벳을 가지고 활용해야하는데
		 * 그 과정은 queue를 이용해서 해결하였어.
		*/
		
		int answer = 0;
		

		char[] words = name.toCharArray();
		int len = words.length;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);

		StringBuilder sb=  new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append("A");
		}
		

		while (!queue.isEmpty()) {
			
			
			int i = queue.poll();
		
			answer += Math.min(words[i] - 'A', Math.abs(Math.abs('Z' - words[i]+1) ));
			
			words[i] = 'A';
			

			int leftIndex = i;
			int rightIndex = i;
			int leftCount = 0;
			int rightCount = 0;

			while (true) {
				leftIndex--;
				if (leftIndex < 0) {
					leftIndex = len - 1;
				}
				leftCount++;
				if(leftCount >= len) {
					return answer;
				}
				if (!(words[leftIndex] == 'A')) {
					break;
				}
			}
			while (true) {
				rightIndex++;
				if (rightIndex >= len) {
					rightIndex = 0;
				}
				rightCount++;

				if (!(words[rightIndex] == 'A')) {
					break;
				}
			}

			int min = Math.min(rightCount, leftCount);
			answer += min;
			
			if (min == rightCount) {
				queue.add(rightIndex);
				continue;
			}
			if (min == leftCount) {
				queue.add(leftIndex);
				
			}
		}

		return answer;
	}
}
