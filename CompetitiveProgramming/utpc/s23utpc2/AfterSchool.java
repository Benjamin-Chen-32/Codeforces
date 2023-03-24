import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AfterSchool {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		long ans = 0;
		if (k == 0) {
			ans = ((n * n) - n) / 2;
		} else {
			for (int i = 1; i <= n; i++) {
				int end = n % i;
				int max = n / i;
				if (max < k) {
					break;
				}
				if (max == k) {
					ans += end + 1;
				} else {
					ans += i;
				}
			}
		}
		System.out.println(ans);
		in.close();
	}
}
