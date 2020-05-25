package dfs.backjoon14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Integer>[] list = new LinkedList[4];

		for (int line_count = 0; line_count < 4; line_count++) {
			list[line_count] = new LinkedList<Integer>();
			String getLine = br.readLine();
			for (String num : getLine.split("")) {
				list[line_count].add(Integer.parseInt(num));
			}

		}
		
		
		
		//

		int testCase = Integer.parseInt(br.readLine());

		for (int test_count = 0; test_count < testCase; test_count++) {
			int move_gear[] = new int[4];
			String line[] = br.readLine().split(" ");
			
			
			int start_gear = Integer.parseInt(line[0]) - 1;
			int move_direction = Integer.parseInt(line[1]);
			
			
			move_gear[start_gear] = move_direction;

			findLeft(list, move_gear, start_gear - 1, move_direction * -1);
			findRight(list, move_gear, start_gear + 1, move_direction * -1);

			for (int idx = 0; idx < move_gear.length; idx++) {
				if (move_gear[idx] == -1) {
					int num = list[idx].remove(0);

					list[idx].addLast(num);
				} else if (move_gear[idx] == 1) {
					int num = list[idx].remove(list[idx].size()-1);

					list[idx].addFirst(num);
				}
			}
		}
		
		int gear_point = 1;
		int answer = 0;
		for (int i = 0; i < list.length; i++) {
			if(list[i].get(0) == 1) {
				answer += gear_point;
			}
			gear_point *= 2;
		}
		
		System.out.println(answer);

	}

	// 2 6
	public static void findLeft(LinkedList<Integer> list[], int move_gear[], int gear, int move_direction) {
		if (gear < 0) {
			return;
		} else {
			if (list[gear + 1].get(6) != list[gear].get(2)) {
				move_gear[gear] = move_direction;
				findLeft(list, move_gear, gear - 1, move_direction * -1);
			}

		}

	}

	public static void findRight(LinkedList<Integer>[] list, int move_gear[], int gear, int move_direction) {
		if (gear > 3) {
			return;
		} else {
			if (list[gear - 1].get(2) != list[gear].get(6)) {
				move_gear[gear] = move_direction;
				findRight(list, move_gear, gear + 1, move_direction * -1);
			}

		}
	}
}
