package kakao2020;
/*
 * 둘다 정사각 둘의 정사각 크기는 다를 수 잇음. 키 회전과 이동.
 */
class RockAndKey {
	boolean answer = false;

	public boolean solution(int[][] key, int[][] lock) {
		// 3 9
		// 2 6
		// 4 12
		int len = lock.length;
		int extendsLock[][] = new int[len * 3][len * 3];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				extendsLock[i + len][j + len] = lock[i][j];
			}
		}

		int count = 0;

		while (count < 4) {
			check(key, extendsLock, 0, 0);
			if (answer)
				break;
			key = rotateKey(key);
			count++;
		}

		return answer;
	}

	public void check(int key[][], int extendsLock[][], int x, int y) {
		if (answer) {
			System.out.println("성공");
			return;
		}
		if (y + key.length > extendsLock.length) {
			y = 0;
			x++;
		}

		if (x + key.length > extendsLock.length) {
			return;
		}

		int len = extendsLock.length;
		int cloneLock[][] = new int[len][len];
		for (int i = 0; i < cloneLock.length; i++) {
			cloneLock[i] = extendsLock[i].clone();
		}
	
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				cloneLock[x + i][y + j] += key[i][j];
			}
		}

		boolean check = true;
		loop: for (int i = 0; i < cloneLock.length / 3; i++) {
			for (int j = 0; j < cloneLock.length / 3; j++) {
				if (cloneLock[cloneLock.length / 3 + i][cloneLock.length / 3 + j] != 1) {
					check = false;
					break loop;
				}
			}
		}
		if (!check) {
			y++;
			check(key, extendsLock, x, y);
		} else {
			answer = true;
		}
	}

	public int[][] rotateKey(int key[][]) {
		int len = key.length;
		int returnKey[][] = new int[len][len];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				// 1,0 -> 0,1
				// 0,1 -> 1,2
				// 2,1 -> 1,0
				// 2,2 -> 2,0
				returnKey[j][len - 1 - i] = key[i][j];
			}
		}

		return returnKey;
	}
}
