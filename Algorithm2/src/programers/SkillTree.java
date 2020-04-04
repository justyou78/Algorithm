package programers;

import java.util.LinkedList;
import java.util.Stack;

public class SkillTree {
	 public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	        LinkedList<Character> ll = new LinkedList<Character>();
	        for (int i = 0; i < skill.length(); i++) {
				ll.add(skill.charAt(i));
			}
	        
	        for (int i = 0; i < skill_trees.length; i++) {
				String skillset = skill_trees[i];
				LinkedList<Character> clonell = (LinkedList<Character>) ll.clone();
				for (int j = 0; j < skillset.length(); j++) {
					char c = skillset.charAt(j);
					if(clonell.contains(c) ) {
						if(clonell.indexOf(c) == 0) {
							clonell.remove(0);
							
						}
						else {
							break;
						}
					}
					
					if(clonell.isEmpty() || skillset.length()-1 == j) {
						answer++;
						break;
					}
				}
			}
	        return answer;
	    }
}
