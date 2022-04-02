import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D1000000 {

	public static void solve(int[] die, int n) {
		Arrays.sort(die);
		int num = 0;
		for (int i = 0; i < n; i++) {
			if (num + 1 <= die[i]) {
				num++;
			}
		}
		System.out.println(num);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int[] die = new int[n];
			for (int j = 0; j < n; j++) {
				die[j] = Integer.parseInt(tk.nextToken());
			}
			System.out.print("Case #" + (i + 1) + ": ");
			solve(die, n);
		}
		in.close();
	}
}
