import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimePrecipitation {
	  
	static int spf[];
	static void sieve(int n) {
		spf[1] = 1;
		for (int i = 2; i < n; i++)
			spf[i] = i;

		for (int i = 4; i < n; i += 2)
			spf[i] = 2;
	  
		for (int i = 3; i * i < n; i++) {
			if (spf[i] == i) {
				for (int j = i * i; j < n; j += i)
					if (spf[j] == j)
						spf[j] = i;
			}
		}
	}

	static int primes(int x) {
		int ans = 0;
		while (x != 1) {
			ans++;
			x = x / spf[x];
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		long[] dp = new long[n + 1];
		spf = new int[n + 1];
		sieve(n + 1);
		dp[1] = 0;
		long ans = 0;
		for (int i = 2; i <= n; i++) {
			int move = primes(i);
			dp[i] = dp[i - move] + 1;
			ans += dp[i];
		}
		System.out.println(ans);
		in.close();
	}
}
