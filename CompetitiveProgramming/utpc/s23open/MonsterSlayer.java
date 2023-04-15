import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MonsterSlayer {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] powers = new int[n];
		for (int i = 0; i < n; i++) {
			powers[i] = Integer.parseInt(tk.nextToken());
		}
		int[] dp = new int[n];
		dp[0] = powers[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + powers[i], powers[i]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		out.println(ans);
		in.close();
		out.close();
	}
}