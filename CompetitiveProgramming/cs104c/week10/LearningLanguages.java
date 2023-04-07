import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LearningLanguages {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] langs = new LinkedList[m];
		for (int i = 0; i < m; i++) {
			langs[i] = new LinkedList<Integer>();
		}
		HashSet<Integer> zeros = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(tk.nextToken());
			if (num == 0) {
				zeros.add(i);
			}
			for (int j = 0; j < num; j++) {
				int lang = Integer.parseInt(tk.nextToken()) - 1;
				langs[lang].add(i);
			}
		}
		DisjointSet ds = new DisjointSet(n);
		int cost = zeros.size();
		for (int i = 0; i < m; i++) {
			if (langs[i].isEmpty()) {
				continue;
			}
			int init = langs[i].poll();
			for (int person : langs[i]) {
				ds.union(init, person);
			}
		}
		for (int i = 0; i < n; i++) {
			if (zeros.contains(i)) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {
				if (zeros.contains(j)) {
					continue;
				}
				if (!ds.find(i, j)) {
					ds.union(i, j);
					cost++;
				}
			}
		}
		out.println(cost);
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
			} else {
				parent[bRoot] = parent[aRoot];
				size[aRoot] += size[bRoot];
			}
		}
	}
}