import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LazySanta {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int[] houses = new int[K];
		for (int i = 0; i < K; i++) {
			houses[i] = Integer.parseInt(in.readLine());
		}
		LinkedList<Edge>[] graph = new LinkedList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new LinkedList<Edge>();
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		int[] dists = new int[N + 1];
		Arrays.fill(dists, Integer.MAX_VALUE);
		dists[0] = 0;
		q.add(0);
		while (!q.isEmpty()) {
			int curr = q.pop();
			for (Edge adj : graph[curr]) {
				if (dists[curr] + adj.dist < dists[adj.node]) {
					q.add(adj.node);
					dists[adj.node] = dists[curr] + adj.dist;
				}
			}
		}
		long totalTravel = 0;
		long maxDist = 0;
		for (int i = 0; i < K; i++) {
			int dist = dists[houses[i]];
			totalTravel += dist;
			maxDist = Math.max(maxDist, dist);
		}
		totalTravel *= 2;
		maxDist *= 2;
		System.out.println(totalTravel + " " + maxDist);
		in.close();
	}

	static class Edge {
		int node;
		int dist;

		public Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
}
