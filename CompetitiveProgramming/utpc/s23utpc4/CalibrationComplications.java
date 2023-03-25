import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CalibrationComplications {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		long[] a = new long[n];
		long[] b = new long[n];

		long maxA = 0;
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tk.nextToken());
			maxA = Math.max(maxA, a[i]);
		}

		long minB = Long.MAX_VALUE;
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(tk.nextToken());
			minB = Math.min(minB, b[i]);
		}

		if (maxA > minB) {
			out.println(-1);
		} else {
			long ans = 0;
			for (int i = 0; i < n; i++) {
				ans += maxA - a[i]; 
				ans += b[i] - minB;
			}
			ans += (minB - maxA) * n;
			out.println(ans);
		}

		in.close();
		out.close();
	}
}