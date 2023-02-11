import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BrownieBaking {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] reqs = new int[n];
		for (int i = 0; i < n; i++) {
			reqs[i] = Integer.parseInt(tk.nextToken());
		}
		tk = new StringTokenizer(in.readLine());
		int[] tins = new int[m];
		for (int i = 0; i < m; i++) {
			tins[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(reqs);
		Arrays.sort(tins);
		int ans = 0;
		int currTin = m - 1;
		for (int i = n - 1; currTin >= 0 && i >= 0; i--) {
			if (tins[currTin] >= reqs[i]) {
				ans++;
				currTin--;
			}
		}
		System.out.println(ans);
		in.close();
	}
}
