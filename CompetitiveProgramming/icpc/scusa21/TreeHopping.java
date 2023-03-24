import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHopping {
	static class LCA {
		int[] depth;
		int[][] parent;
		int level;
		LinkedList<Integer>[] adjList;
		int N;

		public LCA(LinkedList<Integer>[] adjList, int N) {
			this.adjList = adjList;
			this.N = N;
			level = (int) (Math.ceil(Math.log(N) / Math.log(2)));
			depth = new int[N];
			parent = new int[N][level];
			bfsLCA(0);
			precomputeSparseMatrix();
		}

		public void bfsLCA(int curr) {
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N];
			queue.add(curr);
			visited[curr] = true;
			parent[curr][0] = -1;
			while (!queue.isEmpty()) {
				int el = queue.poll();
				for (int adj : adjList[el]) {
					if (!visited[adj]) {
						visited[adj] = true;
						depth[adj] = depth[el] + 1;
						parent[adj][0] = el;
						queue.add(adj);
					}
				}
			}
		}

		public void precomputeSparseMatrix() {
			for (int i = 1; i < level; i++) {
				for (int node = 0; node < N; node++) {
					if (parent[node][i - 1] != -1)
						parent[node][i] = parent[parent[node][i - 1]][i - 1];
				}
			}
		}

		public int lca(int u, int v) {
			if (depth[v] < depth[u]) {
				int temp = u;
				u = v;
				v = temp;
			}
			int diff = depth[v] - depth[u];
			int dist = diff;
			for (int i = 0; i < level; i++) {
				if (((diff >> i) & 1) == 1) {
					v = parent[v][i];
				}
			}
			int orig_u = u;
			if (u == v) {
				return dist;
			}
			for (int i = level - 1; i >= 0; i--) {
				if (parent[u][i] != parent[v][i]) {
					u = parent[u][i];
					v = parent[v][i];
				}
			}
			dist += (depth[orig_u] - depth[parent[u][0]]) * 2;
			return dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(tk.nextToken());
		for (int _i = 0; _i < t; _i++) {
			tk = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(tk.nextToken());
			LinkedList<Integer>[] edgeList = new LinkedList[n];
			for (int j = 0; j < n; j++)
				edgeList[j] = new LinkedList<>();
			for (int j = 0; j < n - 1; j++) {
				tk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(tk.nextToken()) - 1;
				int b = Integer.parseInt(tk.nextToken()) - 1;
				edgeList[a].add(b);
				edgeList[b].add(a);
			}
			int[] perms = new int[n];
			for (int j = 0; j < n; j++) {
				tk = new StringTokenizer(in.readLine());
				perms[j] = Integer.parseInt(tk.nextToken()) - 1;
			}

			LCA lca = new LCA(edgeList, n);
			boolean valid = true;
			for (int j = 0; j < n - 1; j++) {
				int res = lca.lca(perms[j], perms[j + 1]);
				if (res > 3) {
					valid = false;
					break;
				}
			}
			if (valid)
				System.out.println(1);
			else
				System.out.println(0);
		}
		in.close();
	}
}