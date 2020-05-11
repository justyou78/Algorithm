package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final String operator[] = { "+", "*", "/", "-", "(", ")" };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 원하지 않는 문자가 들어왔을 경우.
		// 공백 처리
		// 문자 크기는 생각하지않기.
		// 왜 -*가 안될까?
		String str = br.readLine().replaceAll("[^0-9+-/*()]", "").trim();
		System.out.println(str);

		// 괄호의 갯수가 일치하지 않을 경우.

		// 후위 표기식 변환

		// 연산자를 담을 스택
		Stack<String> stack = new Stack<String>();
		// 후위표기식이 들어갈 리스트
		ArrayList<String> al = new ArrayList<String>();

		StringTokenizer stz = new StringTokenizer(str, "[+-/*()]", true);
		// 각 토큰을 가져와 체크 확인과정
		while (stz.hasMoreTokens()) {

			String getToken = stz.nextToken();

			// 연산이 가능한 수식인지 확인한다.
			isPossibleCalculator(getToken);

			// 연산자인지 확인한다.
			if (isOperator(getToken, stack, al)) {
			} else {
				al.add(getToken);
			}

		}

		// 스택에 남아있는 연산자 털어내기.
		while (!stack.isEmpty()) {
			al.add(stack.pop());
		}

		for (String st : al) {
			System.out.print(st + " ");

		}

	}

	// 괄호의 갯수 ( -1이 될 경우 열린괄호가 없으므로 잘못된 괄호방식 )
	static int bracketCount = 0;

	private static boolean isOperator(String getToken, Stack<String> stack, ArrayList<String> al) {

		for (int i = 0; i < operator.length; i++) {
			// 스태틱으로 입력한 연산자와 토큰을 비교
			if (operator[i].equals(getToken)) {

				// 연산자이지만 스택이 비어있다면 채워넣기.
				if (stack.isEmpty()) {
					if (getToken.contentEquals(")")) {

						isPossibleBacket(--bracketCount);
					}
					stack.push(getToken);
					// 스택이 비어있지 않을경우.
				} else {

					// 닫히는 괄호일경우
					if (getToken.equals(")")) {
						isPossibleBacket(--bracketCount);
						// 스택이 비어있거나 열린괄호가 나타날때까지 연산자 스택의 내용을 털어낸다.
						while (!stack.isEmpty()) {
							// 열린괄호를 만나면 스탑!
							if (stack.peek().equals("(")) {
								stack.pop();
								break;
							}
							// 스택의 연산자들 후위표기식에 넣기.
							al.add(stack.pop());

						}
						// 열린괄호일경우
					} else if (getToken.equals("(")) {
						bracketCount++;
						stack.add(getToken);
					}

					// 가져온 토큰이 스택의 값보다 크거나 같다면 그냥 스택에 쌓는다.
					else if (OperatorPriority(getToken, stack) >= OperatorPriority(stack.peek(), stack)) {
						stack.add(getToken);

					}
					// 아니면 스택에 저장되어 있던 내용을 꺼내서 후위표기식에 집어넣고 가져온 토큰을 스택에 삽입한다.
					else {
						al.add(stack.pop());
						stack.add(getToken);
					}

				}

				return true;

			}

		}
		return false;

	}

	// 괄호가 잘되어있는지 확인하는 메서드
	private static void isPossibleBacket(int i) {
		if (i < 0) {
			System.out.println("괄호가 잘못된 방식으로 기입되었습니다.");
			System.exit(1);
		}
	}

	// 이전의 스트링값을 저장하는 문자열
	static String beforeString = "";

	// 예외 토큰값에따라 이전의 토큰을 확인하여 잘못된 수식인지 확인한다.
	private static void isPossibleCalculator(String getToken) {

		// 닫힌 괄호일경우 이전의 문자열이 연산자(+-/*) 이면 잘못된 수식의 문자열
		if (getToken.equals(")")) {

			if (beforeString.matches("[+-/*]")) {
				System.out.println("잘못된 수식입니다.");
				System.exit(1);
			}
			// 연산자일경우(+-/*) 이전의 문자열이 연산자 혹은 열린괄호일경우 잘못된 연산자.
		} else if (getToken.matches("[+-/*]") && beforeString.matches("[+-/*(]")) {

			System.out.println("잘못된 수식입니다.");
			System.exit(1);

		}
		// 열린괄호이고 이전의 문자열이 숫자인경우 잘못된 수식. ex) 300( 의 경우 곱하기로 생각하지않고 잘못된 수식으로 처리
		else if (getToken.equals("(")) {
			try {
				Integer.parseInt(beforeString);
				System.out.println("잘못된 수식입니다.");
				System.exit(1);

			} catch (Exception e) {

			}
		}
		// 숫자이고 이전의 문자열이 닫힌 괄호일 경우 잘못된 수식. ex) )300 의 경우 곱하기로 생각하지않고 잘못된 수식으로 처리
		else if (beforeString.equals(")")) {
			try {
				Integer.parseInt(getToken);
				System.out.println("잘못된 수식입니다.");
				System.exit(1);
			} catch (Exception e) {

			}

		} else {
			beforeString = getToken;
		}

	}

	private static int OperatorPriority(String getToken, Stack<String> stack) {
		switch (getToken) {
		case "+":
		case "-":

			return 1;
		case "*":
		case "/":

			return 2;

		}

		return -1;
	}

}
