import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MiddleManagement {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		int[] productivity = new int[n];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			productivity[i] = Integer.parseInt(tk.nextToken()) * Integer.parseInt(tk.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += productivity[i];
		}
		int ans = sum;
		for (int i = k; i < n; i++) {
			sum += productivity[i];
			sum -= productivity[i - k];
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		in.close();
	}
}
