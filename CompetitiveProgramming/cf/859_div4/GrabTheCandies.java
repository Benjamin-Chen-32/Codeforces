import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrabTheCandies {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(tk.nextToken());
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(in.readLine());
			tk = new StringTokenizer(in.readLine());
			int[] a = new int[n];
			int evenSum = 0;
			int oddSum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(tk.nextToken());
			}
			for (int i = 0; i < n; i++) {
				if (a[i] % 2 == 0) {
					evenSum += a[i];
				} else {
					oddSum += a[i];
				}
			}
			if (oddSum >= evenSum) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		in.close();
	}
}
