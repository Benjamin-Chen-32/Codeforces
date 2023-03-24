import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SummitSunset {

	static final int[] dirR = { 0, 0, 1, -1 };
	static final int[] dirC = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] grid = new int[n][n];
		int maxHeight = 0;
		int endR = 0;
		int endC = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
				if (grid[i][j] > maxHeight) {
					maxHeight = grid[i][j];
					endR = i;
					endC = j;
				}
			}
		}
		int[][] ret = dijkstra(grid, n);
		System.out.println(ret[endR][endC]);
		in.close();
	}

	static int[][] dijkstra(int[][] grid, int N) {
		PriorityQueue<Node> heap = new PriorityQueue<Node>();
		int[][] dists = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dists[i], Integer.MAX_VALUE);
		}
		boolean[][] inSet = new boolean[N][N];
		heap.add(new Node(0, 0, 0));
		dists[0][0] = 0;

		while (!heap.isEmpty()) {
			Node u = heap.poll();
			int r = u.r;
			int c = u.c;
			inSet[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int newR = r + dirR[i];
				int newC = c + dirC[i];
				if (!inBounds(newR, newC, N, N)) {
					continue;
				}
				int heightDiff = grid[r][c] - grid[newR][newC];
				int distsThroughU = dists[r][c] + heightDiff * heightDiff;
				if (!inSet[newR][newC]) {
					if (distsThroughU < dists[newR][newC]) {
						dists[newR][newC] = distsThroughU;
						heap.add(new Node(newR, newC, distsThroughU));
					}
				}
			}
		}
		return dists;
	}

	// In range of an matrix
	static boolean inBounds(int r, int c, int R, int C) {
		if (r < R && r >= 0 && c < C && c >= 0) {
			return true;
		}
		return false;
	}

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
	}
}
