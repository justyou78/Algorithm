package Greeedy;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers42884 {
	  public int solution(int[][] routes) {
			int answer = 0;
			
			ArrayList<Order> al = new ArrayList<Order>();
			for (int i = 0; i < routes.length; i++) {
				al.add(new Order(routes[i][0],routes[i][1]));
				
			}
			Collections.sort(al);
			boolean check[]= new boolean[al.size()];
				
				for (int i = 0; i < al.size(); i++) {
					Order o;
	              
					if(!check[i]){
						o =  al.get(i);
	                    answer++;
						check[i] = true;
						for (int j = i+1; j < al.size(); j++) {
							if(!check[j] && o.start <= al.get(j).end) {
								check[j] = true;
							}
						}
					}
					
				}
				
			
			
			
			return answer;
		}
		
	}

	class Order implements Comparable<Order> {
		int start;
		int end;

		public Order(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Order o) {
			
			if(this.start > o.start) {
				return -1;
			}
			else if(this.start == o.start) {
				return o.end - this.end;
			}
			
			return 1;
		}

	}