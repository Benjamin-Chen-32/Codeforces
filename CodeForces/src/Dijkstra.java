import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
	int N;
	int M;
	LinkedList<DijEdge>[] adjList;
	
	public Dijkstra(int N, int M, LinkedList<DijEdge>[] adjList) {
		this.N = N;
		this.M = M;
		this.adjList = adjList;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		@SuppressWarnings("unchecked")
		LinkedList<DijEdge>[] adjList = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<DijEdge>();
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			int w = Integer.parseInt(tk.nextToken());
			adjList[a].add(new DijEdge(b, w));
			adjList[b].add(new DijEdge(a, w));
		}
		Dijkstra solver = new Dijkstra(N, M, adjList);
		int[] prevs = solver.dijkstra(0);
		LinkedList<Integer> path = new LinkedList<Integer>();
		int curr = N - 1;
		path.add(N - 1);
		while (curr != 0 && curr != -1) {
			curr = prevs[curr];
			path.addFirst(curr);
		}
		if (path.peek() != 0) {
			System.out.println(-1);
		} else {
			for (int i : path) {
				System.out.print((i + 1) + " ");
			}
			System.out.println();
		}
		in.close();
	}
	
	public int[] dijkstra(int root) {
		PriorityQueue<DijNode> q = new PriorityQueue<DijNode>();
		int[] prevs = new int[N];
		boolean[] inSet = new boolean[N];
		int[] dists = new int[N];
		Arrays.fill(dists, Integer.MAX_VALUE);
		Arrays.fill(prevs, -1);
		dists[root] = 0;
		q.add(new DijNode(root, 0));
		while (!q.isEmpty()) {
			int u = q.poll().num;
			inSet[u] = true;
			LinkedList<DijEdge> adj = adjList[u];
			for (DijEdge currEdge : adj) {
				int v = currEdge.other;
				int distThroughU = dists[u] + currEdge.weight;
				if (!inSet[v]) {
					if (distThroughU < dists[v]) {
						dists[v] = distThroughU;
						q.add(new DijNode(v, dists[v]));
						prevs[v] = u;
					}
				}
			}
		}
		return prevs;
	}
}

class DijEdge {
	int other;
	int weight;
	
	public DijEdge(int other, int weight) {
		this.other = other;
		this.weight = weight;
	}
}

class DijNode implements Comparable<DijNode> {
	int num;
	int dist;
	
	public DijNode(int num, int dist) {
		this.num = num;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(DijNode other) {
		// TODO Auto-generated method stub
		if (this.dist == other.dist) {
			return Integer.compare(this.num, other.num);
		}
		return Integer.compare(this.dist, other.dist);
	}
}