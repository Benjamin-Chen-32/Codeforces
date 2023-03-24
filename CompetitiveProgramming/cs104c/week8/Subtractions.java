import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subtractions {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int ans = 0;
			while (a > 0 && b > 0) {
				int big = Math.max(a, b);
				int small = Math.min(a, b);
				if (big == small) {
					ans++;
					break;
				}
				int times = big / small;
				if (big % small == 0) {
					times = (big / small) - 1;
				}
				a = big - (small * times);
				b = small;
				ans += times;
			}
			System.out.println(ans);
		}
		in.close();
	}
}
