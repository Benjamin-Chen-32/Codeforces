import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CaesarsLegion {

	static final long MOD = 100000000;

	int N1;
	int N2;
	int K1;
	int K2;
	long[][][][] dp;

	public CaesarsLegion(int N1, int N2, int K1, int K2) {
		this.N1 = N1;
		this.N2 = N2;
		this.K1 = K1;
		this.K2 = K2;
		dp = new long[2][Math.max(K1, K2) + 1][N1 + 1][N2 + 1];
		for (int i = 0; i < Math.max(K1, K2) + 1; i++) {
			for (int j = 0; j < N1 + 1; j++) {
				for (int k = 0; k < N2 + 1; k++) {
					dp[0][i][j][k] = -1;
					dp[1][i][j][k] = -1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N1 = Integer.parseInt(tk.nextToken());
		int N2 = Integer.parseInt(tk.nextToken());
		int K1 = Math.min(Integer.parseInt(tk.nextToken()), N1);
		int K2 = Math.min(Integer.parseInt(tk.nextToken()), N2);
		CaesarsLegion solve = new CaesarsLegion(N1, N2, K1, K2);
		long ans = 0;
		for (int i = 1; i <= K1; i++) {
			ans += solve.recurse(N1 - 1, N2, i, true) % MOD;
		}
		for (int i = 1; i <= K2; i++) {
			ans += solve.recurse(N1, N2 - 1, i, false) % MOD;
		}
		System.out.println(ans % MOD);
		in.close();
	}

	public long recurse(int numFoot, int numHorse, int numConsecutive, boolean lastFoot) {
		if (numFoot == 0) {
			if (numHorse > K2) {
				return 0L;
			}
			return 1L;
		}
		if (numHorse == 0) {
			if (numFoot > K1) {
				return 0L;
			}
			return 1L;
		}
		if (dp[(lastFoot) ? 0 : 1][numConsecutive][numFoot][numHorse] != -1) {
			return dp[(lastFoot) ? 0 : 1][numConsecutive][numFoot][numHorse];
		}
		long ans;
		if (lastFoot) {
			long sum = 0;
			if (numHorse > 0) {
				for (int i = 1; i <= K2 && i <= numHorse; i++) {
					sum += recurse(numFoot, numHorse - 1, i, false) % MOD;
				}
			}
			if (numConsecutive == 1) {
				ans = sum;
			} else {
				ans = recurse(numFoot - 1, numHorse, numConsecutive - 1, true) % MOD;
			}
		} else {
			long sum = 0;
			if (numFoot > 0) {
				for (int i = 1; i <= K1 && i <= numFoot; i++) {
					sum += recurse(numFoot - 1, numHorse, i, true) % MOD;
				}
			}
			if (numConsecutive == 1) {
				ans = sum;
			} else {
				ans = recurse(numFoot, numHorse - 1, numConsecutive - 1, false) % MOD;
			}
		}
		dp[(lastFoot) ? 0 : 1][numConsecutive][numFoot][numHorse] = ans;
		return ans;
	}
}