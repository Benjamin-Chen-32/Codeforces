import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DiceCombinations {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = i - 1; j >= 0 && j >= i - 6; j--) {
				dp[i] += dp[j];
				dp[i] %= 1000000007;
			}
			if (i <= 6) {
				dp[i]++;
			}
		}
		out.println(dp[n]);
		in.close();
		out.close();
	}
}