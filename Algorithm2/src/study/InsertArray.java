package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InsertArray {
	public void exe() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			al.add(Integer.parseInt(br.readLine()));
			
		}
		/*
		 * for문 2개 처음은 뽑는 인덱스
		 * 두번째는 비교하는 포문
		 * 뽑은 인덱스가 작으면 쭉가고
		 * 아니면 
		*/
		int index =1;
		
		for (int i = 1; i < al.size(); i++) {
			index = i-1;
			while(true) {
				if(al.get(index) > al.get(i)) {
					index--;
				}
				else {
					int num =al.remove(i);
					al.add(index+1, num);
					break;
				}
				if(index == -1) {
					int num = al.remove(i);
					
					al.add(0,num);
					
					break;
				}
			}
		}
			
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}
}
