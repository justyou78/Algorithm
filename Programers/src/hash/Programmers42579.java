package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Programmers42579 {
	public int[] solution(String[] genres, int[] plays) {
		/// 장르 > 많이 재생된 노래 > 고유번호가 낮은 노래
		
		HashMap<String, Integer> genresList = new HashMap<String, Integer>();
		HashMap<String, HashMap<Integer, Integer>> serial_Plays = new HashMap<String, HashMap<Integer,Integer>>();
		
		 ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < plays.length; i++) {
			
			String getGenres = genres[i];
			int getPlays = plays[i];
			HashMap<Integer, Integer> infoMap;
			if(genresList.containsKey(getGenres)) {
				genresList.put(getGenres, getPlays+genresList.get(getGenres));
				
				infoMap  = serial_Plays.get(getGenres);
				
			}
			else {
				genresList.put(getGenres, getPlays);
				
				infoMap =  new HashMap<Integer, Integer>();
					
			}
			infoMap.put(i,getPlays);
			serial_Plays.put(getGenres, infoMap);
			
		}
		
		Iterator it = sortByValue(genresList).iterator();
		
		
		while(it.hasNext()) {
			String key = (String)it.next();
			// pop, classic
			
			 Iterator it2 =sortByValue(serial_Plays.get(key)).iterator();
			int idx2= 0;
			 while(it2.hasNext()) {
				 al.add((int)it2.next());
				idx2++;
				if(idx2 >1 ) {
					break;
				}
				
			}
		}
		int[] answer = new int[al.size()];

        for(int i = 0; i < al.size(); i++){
            answer[i] = al.get(i);
        }
		
		return answer;
	}
	
	public List sortByValue(HashMap map){
		ArrayList<Object> keyList = new ArrayList<Object>();
		keyList.addAll(map.keySet());
		
		Collections.sort(keyList, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				int v1 = (int)map.get(o1);
				int v2 = (int)map.get(o2);
				
				if(v2 > v1) {
					return 1;
				}else if (v2 == v1) {
					return((Comparable) o1).compareTo(o2);
				}else {
					return -1;
				}
				
			}
		});
		return keyList;
		
	}

}