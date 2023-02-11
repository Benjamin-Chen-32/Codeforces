import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PingPongEz {

	static int[] starts;
	static int[] ends;
	static boolean[] vis;
	static int intervals;

	static void dfs(int x) {
		vis[x] = true;
		for (int i = 0; i < intervals; i++) {
			if (((starts[x] > starts[i] && starts[x] < ends[i]) || (ends[x] > starts[i] && ends[x] < ends[i])) && !vis[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		starts = new int[n];
		ends = new int[n];
		Arrays.fill(starts, Integer.MAX_VALUE);
		Arrays.fill(ends, Integer.MAX_VALUE);
		intervals = 0;
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(tk.nextToken());
			if (t == 1) {
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				starts[intervals] = x;
				ends[intervals] = y;
				intervals++;
			} else {
				int a = Integer.parseInt(tk.nextToken()) - 1;
				int b = Integer.parseInt(tk.nextToken()) - 1;
				vis = new boolean[intervals];
				dfs(a);
				if (vis[b]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		in.close();
	}
}
