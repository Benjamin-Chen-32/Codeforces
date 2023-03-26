import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Showstopper {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine());
		outer:
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(in.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			StringTokenizer tk = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(tk.nextToken());
			}
			tk = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				b[i] = Integer.parseInt(tk.nextToken());
			}
			int maxA = a[n - 1];
			int maxB = b[n - 1];
			int smaller = Math.min(maxA, maxB);
			int bigger = Math.max(maxA, maxB);
			for (int i = 0; i < n - 1; i++) {
				if (a[i] > smaller && b[i] > smaller) {
					out.println("No");
					continue outer;
				}
				if (a[i] > bigger || b[i] > bigger) {
					out.println("No");
					continue outer;
				}
			}
			out.println("Yes");
		}
		
		in.close();
		out.close();
	}
}