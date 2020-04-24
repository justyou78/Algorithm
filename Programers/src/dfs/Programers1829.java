package dfs;

public class Programers1829 {
	
	int M;
	int N;
	int maxWith;
	int move[][];
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		
		maxWith = 0;
		move = new int[m][n];
		int move[][] =  { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		this.move = move;
		M = m;
		N = n;
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if ( picture[i][j] != 0) {
					dfs(picture, i, j, picture[i][j]);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxWith, maxSizeOfOneArea);
					maxWith = 0;
				}
			}
		}
		
		
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public void dfs(int picture[][],  int x, int y, int color) {
	
		
		if (picture[x][y] != color) {
			return ;
		}
		maxWith+=1;
		
		picture[x][y] = 0;
		for (int i = 0; i < move.length; i++) {
			int moveX = x + move[i][0];
			int moveY = y + move[i][1];
			if (moveX< 0 || moveX >= M|| moveY < 0 || moveY >= N ||  picture[moveX][moveY] == 0) continue;
			if (picture[moveX][moveY] != color) continue;

			dfs(picture,  moveX, moveY, color);

		}

	}
}
