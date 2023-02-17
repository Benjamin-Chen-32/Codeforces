import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FactoryMachines {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int t = Integer.parseInt(tk.nextToken());
		int[] times = new int[n];
		tk = new StringTokenizer(in.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(tk.nextToken());
			min = Math.min(min, times[i]);
		}
		// First element which is >= value or arr.length if doesn't exist
		long l = 1;
		long r = (long) min * t;
		while (l < r) {
			long mid = (l / 2) + (r / 2) + ((l % 2 + r % 2) / 2);
			if (works(mid, times, t)) { // First element that satisfies this
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(l);
		in.close();
	}

	static boolean works(long allotedTime, int[] times, int t) {
		long prods = 0;
		for (int time : times) {
			prods += allotedTime / time;
			if (prods >= t) {
				return true;
			}
		}
		return false;
	}
}
