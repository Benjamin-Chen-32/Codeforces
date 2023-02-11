import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HighScore {

	static boolean[] changed;

	static boolean relax(LinkedList<Edge>[] adj, long[] dist, int N) {
		boolean relaxed = false;
		changed = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (Edge e : adj[i]) {
				int j = e.other;
				if (dist[i] != Long.MAX_VALUE && dist[i] + e.weight < dist[j]) {
					dist[j] = dist[i] + e.weight;
					relaxed = true;
					changed[j] = true;
				}
			}
		}
		return relaxed;
	}

	
	static class Edge {
		int other;
		long weight;

		public Edge(int o, long w) {
			other = o;
			weight = w;
		}
	}
	@SuppressWarnings("unchecked")

	static long[] bellmanFord(LinkedList<Edge>[] adjList, int N) {
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		for (int i = 0; i < N - 1; i++)
			if (!relax(adjList, dist, N))
				break;
		if (relax(adjList, dist, N)) {
			LinkedList<Edge>[] reverse = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				reverse[i] = new LinkedList<Edge>();
			}
			for (int i = 0; i < N; i++) {
				for (Edge e : adjList[i]) {
					int j = e.other;
					reverse[j].add(new Edge(i, e.weight));
				}
			}
			boolean[] vis = new boolean[N];
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(N - 1);
			vis[N - 1] = true;
			while (!q.isEmpty()) {
				int curr = q.poll();
				if (changed[curr]) {
					dist = null;
					break;
				}
				for (Edge e : reverse[curr]) {
					if (!vis[e.other]) {
						q.add(e.other);
						vis[e.other] = true;
					}
				}
			}
		}
		return dist;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		LinkedList<Edge>[] adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			int x = Integer.parseInt(tk.nextToken());
			adj[a].add(new Edge(b, -x));
		}
		long[] dist = bellmanFord(adj, n);
		if (dist == null) {
			System.out.println(-1);
		} else {
			System.out.println(-dist[n - 1]);
		}
		in.close();
	}
}
