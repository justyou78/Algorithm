package string;


public class Programmers64065 {
	public int[] solution(String s) {
		
		String arr[] = new String[500];
		StringBuilder sb = new StringBuilder();

		int start = 0;
		int count = 0;
		boolean check = false;
		int size= 0;
		for (int i = 1; i < s.length()-1; i++) {
			
			
			if(s.charAt(i) == '{') {
				check = true;
				start = i+1;
			}
			
			else if(s.charAt(i) == '}') {
				
				arr[count] =s.substring(start,i);
				check =false;
				count = 0;
				size++;
				
				
			}
			else if(check &&  s.charAt(i) == ',') {
				count++;
			}
		}
		
		
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		
		int answer[] = new int[size] ;
		
		
		for (int i = 0; i < size; i++) {
			String split[] = arr[i].split(",");
			for (int j = 0; j < split.length; j++) {
				
				for (int j2 = 0; j2 < size; j2++) {
					if(answer[j2] == Integer.parseInt(split[j])) {
						break;
					}
					
					if(answer[j2] == 0 && answer[j2] != Integer.parseInt(split[j]))
					{
						answer[j2] = Integer.parseInt(split[j]);
					}
					
					
				}
			}
			
		}
		
		
		
		
		
		return answer;
	}
}