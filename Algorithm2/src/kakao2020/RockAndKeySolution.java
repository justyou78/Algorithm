package kakao2020;

public class RockAndKeySolution {
	static boolean answer = false;

	public boolean solution(int[][] key, int[][] lock) {
		int len = lock.length;
		int[][] extendsLock = new int[len * 3][len * 3];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				extendsLock[len+ i][len+ j] = lock[i][j];
			}
		}

		dfs(key, extendsLock, 0);

		return answer;

	}

	public void dfs(int[][] key, int[][] lock, int cnt) {
		check(lock, key, 0, 0);
		if (answer)
			return;
		if (cnt >= 4)
			return;
		int[][] temp = rotateArr(key);
		dfs(temp, lock, cnt + 1);

	}

	public void check(int[][] lock, int key[][], int x, int y) {
		if(answer) return;
		if (y + key.length > lock.length) {
			y = 0;
			x++;
		}
		if (x + key.length > lock.length) {
			return;
		}

		int[][] cloneLock = new int[lock.length][lock.length];
		for (int i = 0; i < lock.length; i++) {
			cloneLock[i] = lock[i].clone();
		}

		boolean isFail = false;
		loop: for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				if (key[i][j] == 1) {
					if (cloneLock[i + x][j + y] == 1) {
						isFail = true;
						break loop;
					}
					cloneLock[i + x][j + y] = key[i][j];
				}
			}
		}

//		for (int i = 0; i < cloneLock.length; i++) {
//			for (int j = 0; j < cloneLock.length; j++) {
//				System.out.print(cloneLock[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		if (!isFail) {
			loop: for (int i = 0; i <lock.length/3; i++) {
				for (int j = 0; j < lock.length/3; j++) {
					if (cloneLock[i + lock.length/3][j+lock.length/3] != 1) {
						isFail = true;
						break loop;
					}
				}
			}
		}
		if (!isFail) {
			answer = true;
		}
		check(lock, key, x, y + 1);

	}

	public int[][] rotateArr(int[][] key) { // 회전
		int len = key.length;
		int[][] temp = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				temp[i][j] = key[len - j - 1][i];
			}
		}
		return temp;
	}
}
