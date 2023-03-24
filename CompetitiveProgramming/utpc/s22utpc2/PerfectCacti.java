import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PerfectCacti {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		long k = Long.parseLong(tk.nextToken());
		tk.nextToken();
		long q = Long.parseLong(tk.nextToken());
		TreeSet<Long> set = new TreeSet<>();
		boolean cycle = true;
		for (int i = 0; i < q; i++) {
			tk = new StringTokenizer(in.readLine());
			long a = Long.parseLong(tk.nextToken());
			long b = Long.parseLong(tk.nextToken());
			long c = Long.parseLong(tk.nextToken());
			long min_bc = Math.min(b, c);
			long max_bc = Math.max(b, c);
			long answer = Long.MAX_VALUE;
			if (a == 1) {
				try {
					long ceil = set.ceiling(min_bc);
					if (ceil >= max_bc)
						answer = Math.min(answer, max_bc - min_bc);
				} catch (NullPointerException e) {
					answer = Math.min(answer, max_bc - min_bc);
				}
				if (cycle) {
					try {
						long floor = set.floor(min_bc - 1);
					} catch (NullPointerException e) {
						try {
							if (set.floor(k - 1) < max_bc)
								answer = Math.min(answer, min_bc - max_bc + k);
						} catch (NullPointerException e2) {
							answer = Math.min(answer, min_bc - max_bc + k);
						}
					}
				}
				if (answer == Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(answer);
			} else if (a == 2) {
				if (min_bc == 0 && max_bc == k - 1)
					cycle = false;
				else
					set.add(min_bc);
			} else {
				if (min_bc == 0 && max_bc == k - 1)
					cycle = true;
				else
					set.remove(min_bc);
			}
		}
	}
}