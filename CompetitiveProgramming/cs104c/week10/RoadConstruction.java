import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadConstruction {
	static int num;
	static int sz;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		num = n;
		sz = 1;
		int m = Integer.parseInt(tk.nextToken());
		DisjointSet ds = new DisjointSet(n);
		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			if (!ds.find(a, b)) {
				num--;
			}
			ds.union(a, b);
			out.println(num + " " + sz);
		}
		in.close();
		out.close();
	}

	static class DisjointSet { // Yosupo verified
		int[] parent;
		int[] size;
		int N;

		public DisjointSet(int N) { // O(N)
			this.N = N;
			parent = new int[N];
			size = new int[N];
			Arrays.fill(size, 1);
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
		}

		public int root(int curr) {
			while (parent[curr] != curr) {
				parent[curr] = parent[parent[curr]];
				curr = parent[curr];
			}
			return curr;
		}

		public boolean find(int a, int b) { // O(logN)
			if (root(a) == root(b)) {
				return true;
			}
			return false;
		}

		public void union(int a, int b) { // O(logN)
			int aRoot = root(a);
			int bRoot = root(b);
			if (aRoot == bRoot) {
				return;
			}
			if (size[aRoot] < size[bRoot]) {
				// Subset B is bigger than subset A, so B should be A's parent
				parent[aRoot] = parent[bRoot];
				size[bRoot] += size[aRoot];
				sz = Math.max(sz, size[bRoot]);
			} else {
				parent[bRoot] = parent[aRoot];
				size[aRoot] += size[bRoot];
				sz = Math.max(sz, size[aRoot]);
			}
		}
	}
}