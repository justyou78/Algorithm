package kakao2020;

public class String_compression {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int i = 1; i < s.length(); i++) {
			String unit = s.substring(0, i);
			int isFillTheLast= 0; 
			int count = 1;
			String result = "";
			for (int j = i; j < s.length(); j+=i) {
				if(j+i > s.length()) {
					if(count == 1) result+= unit;
					else result += count + unit;	
					isFillTheLast = j ;
					break;
				}
				String getUnit = s.substring(j, j+i);
				if(unit.equals(getUnit)) {
					count++;
//					if(i+j >= s.length()) {
//						if(count == 1) result+= unit;
//						else result += count + unit;	
//					}
				}else {
					if(count == 1) result+= unit;
					else result += count + unit;
					unit = getUnit;
					count =1;
				}
				//마지막일 경우
				if(i+j == s.length()) {
					if(count == 1) result+= unit;
					else result += count + unit;	
				}
				
				
			}
			if(isFillTheLast != 0) {
				result += s.substring(isFillTheLast, s.length());
			}
			answer = Math.min(answer, result.length());
		}
		
		return answer;
	}

}
