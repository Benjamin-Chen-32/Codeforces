import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GrandestWreath {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int V1 = Integer.parseInt(tk.nextToken());
		LinkedList<Integer>[] g1 = new LinkedList[V1];
		for (int i = 0; i < V1; i++) {
			g1[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < V1 - 1; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			g1[a].add(b);
			g1[b].add(a);
		}
		int V2 = Integer.parseInt(in.readLine());
		LinkedList<Integer>[] g2 = new LinkedList[V2];
		for (int i = 0; i < V2; i++) {
			g2[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < V2 - 1; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			g2[a].add(b);
			g2[b].add(a);
		}
		System.out.println(longestPath(g1) + longestPath(g2) + 2);
		in.close();
	}

	static int longestPath(LinkedList<Integer>[] g) {
		int N = g.length;
		if (N == 1)
			return 0;
		int[] dists = new int[N];
		Arrays.fill(dists, -1);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		dists[0] = 0;
		while (!q.isEmpty()) {
			int curr = q.pop();
			for (int adj : g[curr]) {
				if (dists[adj] == -1) {
					q.add(adj);
					dists[adj] = dists[curr] + 1;
				}
			}
		}
		int maxDist = 0;
		int maxInd = -1;
		for (int i = 0; i < N; i++) {
			int dist = dists[i];
			if (dist > maxDist) {
				maxDist = dist;
				maxInd = i;
			}
		}
		dists = new int[N];
		Arrays.fill(dists, -1);
		q = new LinkedList<Integer>();
		q.add(maxInd);
		dists[maxInd] = 0;
		while (!q.isEmpty()) {
			int curr = q.pop();
			for (int adj : g[curr]) {
				if (dists[adj] == -1) {
					q.add(adj);
					dists[adj] = dists[curr] + 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int dist = dists[i];
			maxDist = Math.max(maxDist, dist);
		}
		return maxDist;
	}
}
