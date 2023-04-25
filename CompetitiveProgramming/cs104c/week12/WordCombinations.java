import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class WordCombinations {

	public static void main(String[] args) throws IOException {
		int mod = 1000000007;
		long mod1 = 4398046511103257L;
		//long mod2 = 4611686018427387853L;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		char[] input = in.readLine().toCharArray();
		int n = input.length;
		int k = Integer.parseInt(in.readLine());
		long[] pows1 = new long[1000000];
		//long[] pows2 = new long[1000000];
		pows1[0] = 1;
		//pows2[0] = 1;
		for (int i = 1; i < 1000000; i++) {
			pows1[i] = (pows1[i - 1] * 28) % mod1;
			//pows2[i] = (pows2[i - 1] * 28) % mod2;
		}
		HashSet<Long> set1 = new HashSet<Long>();
		//HashSet<Long> set2 = new HashSet<Long>();
		for (int i = 0; i < k; i++) {
			char[] s = in.readLine().toCharArray();
			long hash1 = 0;
			//long hash2 = 0;
			for (int j = 0; j < s.length; j++) {
				hash1 += ((s[s.length - j - 1] - 96) * pows1[j]) % mod1;
				//hash2 += ((s[s.length - j - 1] - 96) * pows2[j]) % mod2;
			}
			hash1 %= mod1;
			//hash2 %= mod2;
			set1.add(hash1);
			//set2.add(hash2);
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			long rollingHash1 = 0;
			//long rollingHash2 = 0;
			for (int j = 1; j <= i; j++) {
				rollingHash1 += ((input[i - j] - 96) * pows1[j - 1]) % mod1;
				//rollingHash2 += ((input[i - j] - 96) * pows2[j - 1]) % mod2;
				rollingHash1 %= mod1;
				//rollingHash2 %= mod2;
				if (set1.contains(rollingHash1)) {
					dp[i] += dp[i - j];
					dp[i] %= mod;
				}
			}
		}
		out.println(dp[n]);
		in.close();
		out.close();
	}
}