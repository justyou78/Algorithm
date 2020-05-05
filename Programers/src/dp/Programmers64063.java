package dp;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers64063 {
	public long[] solution(long k, long[] room_number) {

		long ans[] = new long[room_number.length];

		HashMap<Long, Long> hm = new HashMap<Long, Long>();

		for (int i = 0; i < room_number.length; i++) {
			long room = room_number[i];

			if (!hm.containsKey(room)) {
				hm.put(room, room + 1);
				ans[i] = room;
			} else {
				ArrayList<Long> al = new ArrayList<Long>();
				long parent = hm.get(room);
				while (true) {
					if (!hm.containsKey(parent)) {
						hm.put(parent, parent+1);
						ans[i] = parent;
						break;
					}
					else {
						al.add(parent);
						parent = hm.get(parent);
						
					}
				}
				for (long list: al) {
					hm.put(list, parent+1);
					
					
				}
				
				

			}

		}
		return ans;

	}
}