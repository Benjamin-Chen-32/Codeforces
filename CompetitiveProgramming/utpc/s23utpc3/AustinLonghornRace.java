import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class AustinLonghornRace {
 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		Point[] points = new Point[n + 1];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			Point p = new Point(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()),
					Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
			points[i + 1] = p;
		}
		points[0] = new Point(0, 0, 0, 0);
		Arrays.sort(points);
		long[] dp = new long[n + 1];
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			Point cur = points[i];
			for (int j = 0; j < i; j++) {
				long tDif = cur.t - points[j].t;
				long xDif = cur.x - points[j].x;
				long yDif = cur.y - points[j].y;
				if (tDif * tDif >= (xDif * xDif) + (yDif * yDif)) {
					dp[i] = Math.max(dp[i], dp[j] + cur.value);
				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		in.close();
	}
 
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int t;
		int value;
 
		public Point(int x, int y, int t, int value) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.value = value;
		}
 
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.t, o.t);
		}
	}
}
