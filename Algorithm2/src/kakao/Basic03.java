package kakao;

public class Basic03 {
	public String solution(String s) {
	      String answer = "";
	      String st[] = s.split(" ");
	      int min =Integer.MAX_VALUE;
	      int max =Integer.MIN_VALUE;
	      
	      for (String number : st) {
			int  realNumber =  Integer.parseInt(number);
			if(min > realNumber ) {
				min = realNumber;
			}
			
			if(max < realNumber ) {
				max = realNumber;
			}
			
			
		}
	      answer += min+ " " + max;
	      return answer;
	  }

}
