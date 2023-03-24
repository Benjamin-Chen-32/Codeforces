import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnowyHill {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int q = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] hill = new int[n];
		for (int i = 0; i < n; i++) {
			hill[i] = Integer.parseInt(tk.nextToken());
		}
		for (int i = 0; i < q; i++) {
			long k = Long.parseLong(in.readLine());
			int l = 0;
			int h = 0;
			long sum = 0;
			int bestStart = -1;
			int bestEnd = -1;
			while (l <= h && h < n) {
				sum += hill[h];
				if (sum == k) {
					if (bestStart == -1 || bestEnd - bestStart > h - l) {
						bestStart = l;
						bestEnd = h;
					}
					h++;
					sum -= hill[l];
					l++;
				} else if (sum < k) {
					h++;
				} else {
					sum -= hill[l];
					l++;
					sum -= hill[h];
				}
			}
			System.out.println(bestStart + " " + bestEnd);
		}
		in.close();
	}
}
