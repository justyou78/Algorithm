package kakao2020;

import java.util.HashMap;

//public class FindLyricsSolution {
//	 public int[] solution(String[] words, String[] queries) {
//	        int[] answer = new int[queries.length];
//	        
//	        
//	        Trie header  = new Trie('*');
//	        for (int i = 0; i < words.length; i++) {
//				String word = words[i];
//				Trie prev = header;      
//				for (int j = 0; j < word.length(); j++) {
//					Trie newTrie = new Trie(word.charAt(j));
//					prev=prev.putChild(newTrie, word.length());
//				}
//			}
//	        
//	        for (int i = 0; i < queries.length; i++) {
//				String query = queries[i];
//				if(query.charAt(0) == '?') continue;
//				Trie prev = header;
//				for (int j = 0; j < query.length(); j++) {
//					char c = query.charAt(j);
//					if(c == '?') {
//						answer[i] =prev.getChild_LengthAndNum(query.length());
//						break;
//					}
//					prev = prev.getChild(c);
//					if(prev == null) {
//						answer[i] = 0;
//						break;
//					}
//					
//				}
//			}
//	        Trie reverseHeader = new Trie('*');
//	        for (int i = 0; i < words.length; i++) {
//				String word = words[i];
//				Trie prev = reverseHeader;
//				for (int j = word.length()-1;  0 <= j; j--) {
//					Trie t= new Trie(word.charAt(j));
//					prev = prev.putChild(t, word.length());
//				}
//			}
//	        
//	        for (int i = 0; i < queries.length; i++) {
//				String query = queries[i];
//				Trie prev = reverseHeader;
//				
//				
//				//여기서도 효율성이 차이가 난다;;
////				if(query.charAt(query.length()-1) == '?') continue;
//				if(query.charAt(0) != '?') continue;
//				
//				for (int j = query.length()-1; j >= 0 ; j--) {
//					char c= query.charAt(j);
//					if(c == '?') {
//						answer[i] = prev.getChild_LengthAndNum(query.length());
//	                    break;
//					}
//					
//					prev = prev.getChild(c);
//					if(prev == null) {
//						answer[i] = 0;
//						break;
//					}
//				}
//			}
//	        return answer;
//	    }
//		
//		
//	}
//
//
//	 class Trie{
//		char c ;
//		HashMap<Integer, Integer> child_LengthAndNum;
//		HashMap<Character, Trie> child;
//		Trie(char c){
//			this.c = c;
//			child_LengthAndNum = new HashMap<Integer, Integer>();
//			child = new HashMap<Character, Trie>();
//		}
//		
//		public Trie putChild(Trie t, int length) {
//			if(!child.containsKey(t.c))
//			{
//				child.put(t.c, t);
//			}
//			if(child_LengthAndNum.containsKey(length)) {
//	          
//	            child_LengthAndNum.put(length, child_LengthAndNum.get(length)+1);
//			}
//			else {
//				child_LengthAndNum.put(length, 1);
//			}
//			return child.get(t.c);
//			
//		}
//		public int getChild_LengthAndNum(int len) {
//			if(child_LengthAndNum.containsKey(len))  return child_LengthAndNum.get(len);
//			return 0;
//		}
//		public Trie getChild(char c) {
//			return child.get(c);
//		}
//}