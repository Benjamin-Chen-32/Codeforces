import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChainReaction {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());

		int max = 1000001;
		int[] beacons = new int[max];
		int[] dp = new int[max];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());;
			beacons[a] = b;
		}
		if (beacons[0] > 0) {
			dp[0] = 1;
		}
		for (int i = 1; i < max; i++) {
			if (beacons[i] == 0) {
				dp[i] = dp[i - 1];
			} else {
				if (i - beacons[i] > 0) {
					dp[i] = dp[i - beacons[i] - 1] + 1;
				} else {
					dp[i] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < max; i++) {
			ans = Math.max(ans, dp[i]);
		}
		out.println(n - ans);
		in.close();
		out.close();
	}
}