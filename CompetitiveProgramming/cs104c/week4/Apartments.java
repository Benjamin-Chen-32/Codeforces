import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Apartments {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] applicants = new int[n];
		for (int i = 0; i < n; i++) {
			applicants[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(applicants);
		tk = new StringTokenizer(in.readLine());
		TreeMap<Integer, Integer> sizes = new TreeMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			int size = Integer.parseInt(tk.nextToken());
			if (sizes.containsKey(size)) {
				sizes.put(size, sizes.get(size) + 1);
			} else {
				sizes.put(size, 1);
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int lower = applicants[i] - k;
			int upper = applicants[i] + k;
			Integer apt = sizes.ceilingKey(lower);
			if (apt == null) {
				break;
			}
			if (apt <= upper) {
				ans++;
				int dupes = sizes.get(apt);
				if (dupes == 1) {
					sizes.remove(apt);
				} else {
					sizes.put(apt, dupes - 1);
				}
			}
		}
		System.out.println(ans);
		in.close();
	}
}
