import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exponentiation2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			long temp = fastExp(b, c, 1000000006);
			long ans = fastExp(a, temp, 1000000007);
			System.out.println(ans);
		}
		in.close();
	}

	static long fastExp(long base, long exp, long MOD) {
		if (exp == 0) return 1;
		long ans = fastExp(base, exp / 2, MOD);
		ans = (ans * ans) % MOD;
		if (exp % 2 == 1) {
			ans = (base * ans) % MOD;
		}
		return ans;
	}
}
