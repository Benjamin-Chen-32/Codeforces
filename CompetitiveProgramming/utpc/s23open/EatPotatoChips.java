import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EatPotatoChips {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(tk.nextToken());
		int b = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		boolean[][][][] dp = new boolean[a + 1][b + 1][c + 1][2];
		dp[0][0][0][1] = false;
		dp[0][0][0][0] = true;
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if (i == 0 && j == 0 && k == 0) {
						continue;
					}
					for (int y = 0; y < 2; y++) {
						boolean hasTrue = false;
						boolean hasFalse = false;
						for (int x = 1; x <= i; x++) {
							if (dp[i - x][j][k][1 - y]) {
								hasTrue = true;
							} else {
								hasFalse = true;
							}
						}
						for (int x = 1; x <= j; x++) {
							if (dp[i][j - x][k][1 - y]) {
								hasTrue = true;
							} else {
								hasFalse = true;
							}
						}
						for (int x = 1; x <= k; x++) {
							if (dp[i][j][k - x][1 - y]) {
								hasTrue = true;
							} else {
								hasFalse = true;
							}
						}
						for (int x = 1; x <= Math.min(i, Math.min(j, k)); x++) {
							if (dp[i - x][j - x][k - x][1 - y]) {
								hasTrue = true;
							} else {
								hasFalse = true;
							}
						}
						if (y == 0) {
							if (!hasFalse) {
								dp[i][j][k][y] = true;
							}
						} else {
							if (hasTrue) {
								dp[i][j][k][y] = true;
							}
						}
					}
				}
			}
		}
		if (dp[a][b][c][1]) {
			out.println("Yes");
		} else {
			out.println("No");
		}
		in.close();
		out.close();
	}
}