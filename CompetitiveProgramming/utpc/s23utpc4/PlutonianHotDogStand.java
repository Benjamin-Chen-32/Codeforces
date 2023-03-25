import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlutonianHotDogStand {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int d = Integer.parseInt(tk.nextToken());
		int[] a = new int[n];
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tk.nextToken());
		}
		PriorityQueue<Integer> intervals = new PriorityQueue<Integer>(Collections.reverseOrder());
		int max = 0;
		int maxInd = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				intervals.add(i - maxInd);
				maxInd = i;
			}
		}
		if (maxInd != n - 1) {
			intervals.add(n - maxInd);
		}
		int ans = 0;
		while (!intervals.isEmpty() && d > 0) {
			ans += intervals.poll();
			d--;
		}
		if (d > 0) {
			ans += Math.min(n - ans, d);
		}
		out.println(ans);
		in.close();
		out.close();
	}
}