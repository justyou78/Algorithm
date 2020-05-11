package index;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers17676 {
	public int solution(String[] lines) {

		// 9월 15일 기준이네
		// 시 분 초 나노초 -> -2 +1;
		// 각 로그마다 시작과 끝을 계산할 수 있겠지. (로그 갯수 1 <- 2000)
		ArrayList<Log> al = new ArrayList<Log>();
		for (int i = 0; i < lines.length; i++) {
			String st[] = lines[i].split(" ");
			
			al.add(new Log(st[1], st[2]));
		}
		Collections.sort(al);
		
		
		int max = 1;
		for (int i = 0; i < al.size(); i++) {
			Log l = al.get(i);
			float distance = l.end+1f;
			System.out.println(l.start+ " " + l.end);
			System.out.println(distance);
			int count = 1;
			for (int j = i+1; j < al.size(); j++) {
				if(al.get(j).start < distance) {
					count++;
				}
				
				max = Math.max(count, max);
			}
		}

		return max;
	}
}


class Log implements Comparable<Log>{
	float start;
	float end;
	public Log(String time, String milliSecond) {
		double second = 0;
		String st[] = time.split(":");
		second += Double.parseDouble(st[0])  * Math.pow(60, 2);
		second += Double.parseDouble(st[1])  * Math.pow(60, 1);
		second += Double.parseDouble(st[2]);
		this.start = (float) (second - Double.parseDouble(milliSecond.substring(0,milliSecond.length()-1))+0.001);
		this.end = (float)second;
	
	}
	@Override
	public int compareTo(Log o) {
		
		if(this.end >= o.end) {
			return 1;
		}
		else return -1;
		
	}
	
}