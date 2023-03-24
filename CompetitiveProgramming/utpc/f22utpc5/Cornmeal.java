import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cornmeal {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		long ans = 0;
		int ppl = 0;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(tk.nextToken());
		}
		ans = nums[0];
		for (int i = 0; i < n; i++) {
			ppl += nums[i];
			ans = lcm(ans, ppl);
		}
		System.out.println(ans);
		in.close();
	}

	
	static long gcd(long a, long b) {
		long temp = 0;
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
}