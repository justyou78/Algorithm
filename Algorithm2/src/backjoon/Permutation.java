package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		boolean check[] = new boolean[num + 1];
		int arr[] = new int[num];

		permutation(arr, check, num, num);

	}

	public static void permutation(int arr[], boolean check[], int n, int r) {
		if (r == 0) {
			for (int i = 1; i <= n; i++) {
				if (i == n) {
					System.out.print(arr[i - 1]);
				} else {
					System.out.print(arr[i - 1] + " ");
				}
			}
			System.out.println();

		}

		for (int i = 1; i <= n; i++) {
			if (check[i])
				continue;
			check[i] = true;
			arr[n - r] = i;
			permutation(arr, check, n, r - 1);
			check[i] = false;
		}
	}
}
