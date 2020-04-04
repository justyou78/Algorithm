package EST;

import java.util.HashMap;

class Solution04 {
    public String solution(String S, String C) {
    	
    	String company = C.toLowerCase();
    	
    	String names[] = S.split(";");
    	
    	StringBuilder sb = new StringBuilder();
    	HashMap<String, Integer> hm = new HashMap<String, Integer>();
    	for (int i = 0; i < names.length; i++) {
			String getName= names[i].trim();
			String splitName[] =getName.split(" ");
			if(splitName.length == 3) {
				
				splitName[1] = splitName[2];
				String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		        splitName[1] =splitName[1].replaceAll(match, "");
			}
			String key= splitName[0]+splitName[1];
			if(hm.containsKey(key)) {
				sb.append(getName);
				sb.append(" <"+splitName[1].toLowerCase()+"_"+splitName[0].toLowerCase()+hm.get(key)+"@"+company+".com>; ");
				hm.replace(key, hm.get(key)+1);
			}
			else {
				sb.append(getName);
				sb.append(" <"+splitName[1].toLowerCase()+"_"+splitName[0].toLowerCase()+"@"+company+".com>; ");
				
				hm.put(key, 2);
			}
			
			
			
		}
    	
    	
    	
    	
    	return sb.toString().substring(0,sb.toString().length()-2);
    	
    }
}
