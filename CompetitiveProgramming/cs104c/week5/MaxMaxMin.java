import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxMaxMin {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		if (k == 1) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				min = Math.min(min, arr[i]);
			}
			System.out.println(min);
		} else if (k == 2) {
			int max = Math.max(arr[0], arr[n - 1]);
			System.out.println(max);
		} else {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, arr[i]);
			}
			System.out.println(max);
		}
		in.close();
	}
}
