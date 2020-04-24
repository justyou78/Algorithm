package Comparable;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

//Comparable 사용 예시
public class Main {
	public static void main(String[] args) {
		
		//Queue<Disk> queue = new PriorityQueue<>(Collections.reverseOrder((o1, o2) -> (o2.processTime - o1.processTime)));
		
		ArrayList<Point> point =  new ArrayList<Point>();
		point.add(new Point(4,2));
		point.add(new Point(3,1));
		point.add(new Point(2,5));
		point.add(new Point(4,1));
		for (int i = 0; i < point.size(); i++) {
			System.out.println(point.get(i).x + " " + point.get(i).y);
			
		}
		System.out.println("===================================");
		Collections.sort(point);
		for (int i = 0; i < point.size(); i++) {
			System.out.println(point.get(i).x + " " + point.get(i).y);
			
		}
		
		
	}
}



//x에 대한 오름차순 y에 대한 내림차순 정렬
class Point implements Comparable<Point>{
	int x, y;
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int compareTo(Point o) {
		if(this.x < o.x) {
			return 1;
		}
		else if(this.x == o.x) {
			if(this.y <o.y) {
				return 1;
			}
		}
		return -1;
	}
	
}

//스트링을 비교할때
class StringPoint implements Comparable<StringPoint>{
	String s;
	
	
	public StringPoint(String s) {
		this.s = s;
		
		
	}


	


	@Override
	public int compareTo(StringPoint o) {
		return this.s.compareTo(o.s);
	}
	
}
