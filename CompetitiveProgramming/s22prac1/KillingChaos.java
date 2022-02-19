import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KillingChaos {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] passengers = new int[n];
		StringTokenizer tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			passengers[i] = Integer.parseInt(tk.nextToken());
		}
		int[] order = new int[n];
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(tk.nextToken());
		}
		int[] prefix = new int[n + 1];
		prefix[1] = passengers[0];
		for (int i = 2; i <= n; i++) {
			prefix[i] = prefix[i - 1] + passengers[i - 1];
		}
		TreeSet<Integer> bounds = new TreeSet<Integer>();
		bounds.add(-1);
		bounds.add(n);
		int max = round10(prefix[n]);
		int curr = max;
		int numSegs = 1;
		for (int i = 0; i < n; i++) {
			int blow = order[i] - 1;
			int l = bounds.floor(blow);
			int r = bounds.ceiling(blow);
			int lSeg = round10(prefix[blow] - prefix[l + 1]);
			int rSeg = round10(prefix[r] - prefix[blow + 1]);
			curr -= round10(prefix[r] - prefix[l + 1]);
			curr += lSeg + rSeg;
			bounds.add(blow);
			if (blow - l > 1 && r - blow > 1) {
				numSegs++;
			}
			if (r - l <= 2) {
				numSegs--;
			}
			max = Math.max(max, curr * numSegs);
		}
		System.out.println(max);
		in.close();
	}

	static int round10(int x) {
		if (x % 10 == 0) {
			return x;
		}
		return x + 10 - (x % 10);
	}
}
