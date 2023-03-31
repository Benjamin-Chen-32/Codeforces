import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutRibbons {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int a = Integer.parseInt(tk.nextToken());
		int b = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		int[] nums = { a, b, c };
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < nums.length; j++) {
				int cut = nums[j];
				if (i - cut >= 0 && dp[i - cut] != -1) {
					dp[i] = Math.max(dp[i], dp[i - cut] + 1);
				}
			}
		}
		out.println(dp[n]);		
		in.close();
		out.close();
	}
}