package programers;

import java.util.ArrayList;
import java.util.Collections;

public class MockTest {
	public int[] solution(int[] answers) {
		/*
		 * 이차원 배열 3개 만들어주고
		 * answers 포문 돌려주면서
		 * 각 3개의 값 비교해
		 * 각각 length에 도착하면 index 0으로 변경
		 * 정답배열을 한번 정렬해서 리턴
		 * 
		 * 
		
		*/		
		int arr01[] = {1,2,3,4,5};
		int arr02[] = {2,1,2,3,2,4,2,5};
		int arr03[] = {3,3,1,1,2,2,4,4,5,5};
		
		int idx[] = new int[3];
		
		int count[] = new int[3];
		
		for (int i = 0; i < answers.length; i++) {
			int getAnswer= answers[i];
			
			if(arr01[idx[0]] == getAnswer ) {
				count[0]++;
			}
			if(arr02[idx[1]] == getAnswer ) {
				count[1]++;
			}if(arr03[idx[2]] == getAnswer ) {
				count[2]++;
			}
			for (int j = 0; j < count.length; j++) {
				idx[j] ++;
			}
			if(arr01.length == idx[0]) {
				idx[0] = 0;
			}
			if(arr02.length == idx[1]) {
				idx[1] = 0;
			}
			if(arr03.length == idx[2]) {
				idx[2] = 0;
			}
			
			
			
		}
		int max = -1;
		for (int i = 0; i < count.length ; i++) {
			max = Math.max(count[i], max);
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < count.length; i++) {
			if(max == count[i]) {
				al.add(i+1);
			}
		}
		int arr[] = new int[al.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = al.get(i);
		}
		
		
		
		
		return arr;
	}

}
