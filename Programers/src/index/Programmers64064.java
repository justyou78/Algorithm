package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Programmers64064 {
	HashSet<String> hs = new HashSet<String>();

	public int solution(String[] user_id, String[] banned_id) {

		boolean check[] = new boolean[user_id.length];

		ArrayList<String> list = new ArrayList<String>();
		combination(user_id, banned_id, check, 0, banned_id.length, list);

        
		return hs.size();
		
	}

	private void combination(String[] user_id, String[] banned_id, boolean[] check, int start, int r,
			ArrayList<String> list) {
		if (r == 0 && list.size() == banned_id.length) {
			
			ArrayList<String> clonList = (ArrayList<String>) list.clone(); 
			Collections.sort(clonList);
			hs.add(clonList.toString());
			
			return;

		}
		String banned = banned_id[start];
		for (int j = 0; j < user_id.length; j++) {
			if (check[j])
				continue;
			if (banned.length() == user_id[j].length()) {

				int count = 0;
				for (int j2 = 0; j2 < banned.length(); j2++) {

					if (banned.charAt(j2) == user_id[j].charAt(j2) || banned.charAt(j2) == '*') {
						count++;

					} else {
						break;
					}
                    
					
				}
                if (count == banned.length()) {
                       
						check[j] = true;
						list.add(user_id[j]);
						combination(user_id, banned_id, check, start + 1, r - 1, list);
						list.remove(list.size()-1);
						check[j] = false;

					}
			}
		}

	}

}
