package stack;

import java.util.ArrayList;
import java.util.Stack;

public class Programmers64061 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Stack<Integer>> al = new ArrayList<Stack<Integer>>();
		int size = board[0].length;

		for (int i = 0; i < size; i++) {
			al.add(new Stack<Integer>());
		}

		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					al.get(j).push(board[i][j]);
				}
			}

		}

		Stack<Integer> answerStack = new Stack<Integer>();
		for (int i = 0; i < moves.length; i++) {

			int num = moves[i];

			if (!al.get(num - 1).isEmpty()) {

				if (!answerStack.isEmpty() && answerStack.peek() == al.get(num - 1).peek()) {
                    System.out.println(answerStack.peek());
					answerStack.pop();
					al.get(num - 1).pop();
                    answer += 2;
                    
                    answer += remove(answerStack);
				} else {
					answerStack.push(al.get(num - 1).pop());

				}

			}

		}

		return answer;
	}
	
	public int remove(Stack<Integer> answerStack) {
		int returnNum = 0;
		while(answerStack.size() >= 2) {
			if(answerStack.get(answerStack.size()-1) == answerStack.get(answerStack.size()-2)) {
				answerStack.pop();
				answerStack.pop();
				returnNum +=2;
			}
		}
		
		return returnNum;
		
	}
}
