package templates.helpers;

import java.util.Arrays;

public class DP {
	static int lis(int[] arr) {
		int[] tail = new int[arr.length];
		int length = 1;
		tail[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > tail[length - 1]) {
				tail[length++] = arr[i];
			} else {
				int ind = Arrays.binarySearch(tail, 0, length - 1, arr[i]);
				if (ind < 0) {
					ind = -1 * ind - 1;
				}
				tail[ind] = arr[i];
			}
		}
		return length;
	}

	public static int lcs(int[] a, int[] b) {
		int N = a.length;
		int M = b.length;
		int dp[][] = new int[2][M + 1];
		int ind = 0;
		for (int i = 0; i <= N; i++) {
			ind = i & 1;
			for (int j = 0; j <= M; j++) {
				if (i == 0 || j == 0) {
					dp[ind][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					dp[ind][j] = dp[1 - ind][j - 1] + 1;
				} else {
					dp[ind][j] = Math.max(dp[1 - ind][j], dp[ind][j - 1]);
				}
			}
		}
		return dp[ind][M];
	}
}