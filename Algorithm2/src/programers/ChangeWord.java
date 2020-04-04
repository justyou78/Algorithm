package programers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	int answer = 0;

	public int solution(String begin, String target, String[] words) {
		Queue<Word> q = new LinkedList<Word>();
		for (int i = 0; i < words.length; i++) {
			hm.put(words[i], 0);
		}
		int depth = 0;
		q.add(new Word(begin, depth));
		bfs(words,q,target);
		return answer;
	}

	public void bfs(String[] words, Queue<Word> q, String target) {
		if (q.isEmpty()) {

		} else {
			Word w = q.poll();
			if (w.name.equals(target)) {

				answer = w.depth;
			} else {
				int count = 0;
				for (int i = 0; i < words.length; i++) {
					if (hm.get(words[i]) == 1) {
						continue;
					}
					for (int j = 0; j < w.name.length(); j++) {
						if (w.name.charAt(j) == words[i].charAt(j)) {
							count++;
						}
					}
					if (count == w.name.length() - 1) {
						hm.put(words[i], 1);
						q.add(new Word(words[i], w.depth + 1));

					}
					count = 0;

				}
				bfs(words, q, target);

			}
		}
	}

	class Word {
		private String name;
		private int depth;
		private boolean check = false;

		public Word(String name, int depth) {
			super();
			this.name = name;
			this.depth = depth;
		}

		public boolean isCheck() {
			return check;
		}

		public void setCheck(boolean check) {
			this.check = check;
		}

	}
}