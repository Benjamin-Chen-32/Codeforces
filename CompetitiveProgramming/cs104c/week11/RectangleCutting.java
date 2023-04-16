import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RectangleCutting {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(tk.nextToken());
		int b = Integer.parseInt(tk.nextToken());
		int[][] dp = new int[a + 1][b + 1];
		for (int i = 0; i < a + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= Math.min(a, b); i++) {
			dp[i][i] = 0;
		}

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 1; k < i; k++) {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[k][j] + dp[i - k][j]);
				}
				for (int k = 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[i][j - k]);
				}
			}
		}
		out.println(dp[a][b]);
		in.close();
		out.close();
	}
}