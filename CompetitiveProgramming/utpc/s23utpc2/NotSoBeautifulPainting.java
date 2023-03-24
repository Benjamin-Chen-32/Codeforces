import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NotSoBeautifulPainting {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		TreeSet<Point> tree = new TreeSet<Point>();
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int r1 = Integer.parseInt(tk.nextToken()) - 1;
			int c1 = Integer.parseInt(tk.nextToken()) - 1;
			int r2 = Integer.parseInt(tk.nextToken()) - 1;
			int c2 = Integer.parseInt(tk.nextToken()) - 1;
			int paint = r2 - r1 + 1;
			Point a = new Point(c1, paint);
			Point b = new Point(c2 + 1, -paint);
			if (tree.contains(a)) {
				Point exist = tree.floor(a);
				exist.paint += paint;
			} else {
				tree.add(a);
			}
			if (tree.contains(b)) {
				Point exist = tree.floor(b);
				exist.paint -= paint;
			} else {
				tree.add(b);
			}
		}
		for (int i = 0; i < m; i++) {
			int c = Integer.parseInt(in.readLine()) - 1;
			Point a = tree.floor(new Point(c, 0));
			if (a == null) {
				continue;
			}
			a.waters++;
		}
		long curr = 0;
		long ans = 0;
		int prevC = -1;
		int prevWaters = -1;
		for (Point p : tree) {
			if (prevC != -1) {
				ans += curr * (p.c - prevC - prevWaters);
			}
			curr += p.paint;
			prevC = p.c;
			prevWaters = p.waters;
		}
		System.out.println(ans);
		in.close();
	}

	static class Point implements Comparable<Point> {
		int c;
		int paint;

		int waters = 0;

		public Point(int c, int paint) {
			this.c = c;
			this.paint = paint;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(c, o.c);
		}
	}
}
