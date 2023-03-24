import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OddQueries {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(tk.nextToken());
		for (int test = 0; test < t; test++) {
			tk = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(tk.nextToken());
			int q = Integer.parseInt(tk.nextToken());
			int[] a = new int[n];
			tk = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(tk.nextToken());
			}
			boolean[] prefixOdd = new boolean[n];
			prefixOdd[0] = a[0] % 2 != 0;
			for (int i = 1; i < n; i++) {
				boolean odd = a[i] % 2 != 0;
				prefixOdd[i] = prefixOdd[i - 1] ^ odd;
			}
			for (int i = 0; i < q; i++) {
				tk = new StringTokenizer(in.readLine());
				int l = Integer.parseInt(tk.nextToken()) - 1;
				int r = Integer.parseInt(tk.nextToken()) - 1;
				int k = Integer.parseInt(tk.nextToken());
				boolean currOdd = prefixOdd[r] ^ (l == 0 ? false : prefixOdd[l - 1]);
				boolean replOdd = ((r - l + 1) % 2 != 0) && (k % 2 != 0);
				boolean sumOdd = prefixOdd[n - 1];
				if (replOdd != currOdd) {
					sumOdd = !sumOdd;
				}
				if (sumOdd) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		in.close();
	}
}
