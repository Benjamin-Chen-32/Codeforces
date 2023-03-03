import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleDivision {

	static int[] weights;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		weights = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(tk.nextToken());
		}
		System.out.println(search(0, 0, 0, n));
		in.close();
	}

	public static long search(int ind, long left, long right, int n) {
		if (ind == n) {
			return Math.abs(left - right);
		}
		long a = search(ind + 1, weights[ind] + left, right, n);
		long b = search(ind + 1, left, weights[ind] + right, n);
		return Math.min(a, b);
	}
}
