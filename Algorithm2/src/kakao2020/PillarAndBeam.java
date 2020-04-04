package kakao2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PillarAndBeam {
	public int[][] solution(int n, int[][] build_frame) {

		/*
		 * x, y, a, b x,y 교차점의 좌표 a 0 기둥 1 보 0 삭제 1 설치
		 * 
		 * true false boolen만들고 되는지 확인하고 설치 보설치조건을 무조건 오른쪽으로 오르쪽 true인지 or 지금좌표가 true인지
		 * 확인해야겟지 기두은 위아래 true true 그냥 박고 아니면 무시하고
		 * 
		 * true false만들어서 탐색 조지면될거같은데. 결과물 : 00에서 10 방향으로 true가잇는지 확인 상하좌우
		 * 
		 * 
		 * 삽입 삭제 따로 만들어야하네.
		 */

		boolean install[][] = new boolean[n+1][n+1];
		int count = 0;
		for (int i = 0; i < build_frame.length; i++) {
			int build[] = build_frame[i];
			int x = build[0];
			int y = build[1];
			int isPill_beam = build[2];
			int isInstall_delete = build[3];
			// 기둥
			if (isPill_beam == 0) {
				// 설치
				if (isInstall_delete == 1) {
					insert_pillar(x, y, install, count,n);
					print(install);
				}
				// 삭제
				else {
					delete_peallar(x, y, install, count,n);
					print(install);
				}
			}
			// 보
			else {
				// 설치
				if (isInstall_delete == 1) {
					insert_beam(x, y, install, count,n);
					print(install);
				}
				// 삭제
				else {
					delete_beam(x, y, install, count,n);
					print(install);
				}
			}
		}

		return getResult(install, count);
	}

	public int[][] getResult(boolean[][] install, int count) {
		int answer[][] = new int[count][3];
		int index = 0;
		for (int i = 0; i < install.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if (install[i][j] == true) {
					if ( install[i][j + 1] == true) {
						answer[index][0] = i;
						answer[index][1] = j;
						answer[index][2] = 0;
					} else if (install[i + 1][j] == true) {
						answer[index][0] = i;
						answer[index][1] = j;
						answer[index][2] = 1;
					}

				}
			}
		}
		Arrays.sort(answer, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o1[0]) {
					return 1;
				}
				else if(o1[0] == o2[0]) {
					if(o1[1]>o2[1]) {
						return 1;
					}
					else if(o1[1] ==o2[1]) {
						if(o1[2] > o2[2]) {
							return 1;
						}
					}
				}
				return -1;
			}
			
		});
		return answer;
		
	}

	public void insert_pillar(int x, int y, boolean[][] install, int count,int n) {
		// true or 바닥이면 올려주자.
		if ( y == 0 || install[x][y] == true ) {
			count++;
			install[x][y] = true;
			install[x][y + 1] = true;
		}
	}

	public void delete_peallar(int x, int y, boolean[][] install, int count, int n) {
		//양쪽에 보가 있을 경우,  보를 소지하고 있을 경우, 
		//***********************************************
		 
	}

	public void insert_beam(int x, int y, boolean[][] install, int count, int n) {
		if ( install[x][y] == true) {
			install[x + 1][y] = true;
			count++;
		}
		if ( install[x + 1][y] == true) {
			install[x][y] = true;
			count++;
		}
	}

	public void delete_beam(int x, int y, boolean[][] install, int count, int n) {
		if ( install[x + 1][y - 1] == true) {
			install[x][y] = false;
			count--;
		}

	}
	public void print(boolean[][] install) {
		for (int i = install.length-1; i >= 0; i--) {
			for (int j = 0; j < install.length; j++) {
				System.out.print(install[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
