import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WalkInThePark {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		boolean[][] obstacles = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == '#') {
					obstacles[i][j] = true;
				}
			}
		}
		int[][] aPoints = new int[2][2];
		int[][] bPoints = new int[2][2];
		for (int i = 0; i < 2; i++) {
			tk = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(tk.nextToken());
			int col = Integer.parseInt(tk.nextToken());
			aPoints[i][0] = row;
			aPoints[i][1] = col;
		}
		for (int i = 0; i < 2; i++) {
			tk = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(tk.nextToken());
			int col = Integer.parseInt(tk.nextToken());
			bPoints[i][0] = row;
			bPoints[i][1] = col;
		}
		int[][] a1Dists = bfs(new Point(aPoints[0][0], aPoints[0][1], 0), obstacles);
		int[][] a2Dists = bfs(new Point(aPoints[1][0], aPoints[1][1], 0), obstacles);
		int[][] b1Dists = bfs(new Point(bPoints[0][0], bPoints[0][1], 0), obstacles);
		int[][] b2Dists = bfs(new Point(bPoints[1][0], bPoints[1][1], 0), obstacles);
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (obstacles[i][j]) {
					continue;
				}
				if (a1Dists[i][j] != -1 && a2Dists[i][j] != -1 && b1Dists[i][j] != -1 && b2Dists[i][j] != -1) {
					minSum = Math.min(minSum, a1Dists[i][j] + a2Dists[i][j] + b1Dists[i][j] + b2Dists[i][j]);
				}
			}
		}
		if (minSum == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(minSum);
		}
		in.close();
	}

	static int[][] bfs(Point start, boolean[][] obstacles) {
		int[] offsetR = { 0, 0, 1, -1 };
		int[] offsetC = { 1, -1, 0, 0 };
		int[][] dists = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dists[i], -1);
		}
		LinkedList<Point> q = new LinkedList<Point>();
		q.add(start);
		dists[start.r][start.c] = 0;
		while (!q.isEmpty()) {
			Point curr = q.pop();
			for (int k = 0; k < 4; k++) {
				int newR = curr.r + offsetR[k];
				int newC = curr.c + offsetC[k];
				if (inBounds(newR, newC)) {
					if (!obstacles[newR][newC] && dists[newR][newC] == -1) {
						q.add(new Point(newR, newC, curr.dist + 1));
						dists[newR][newC] = curr.dist + 1;
					}
				}
			}
		}
		return dists;
	}

	static boolean inBounds(int r, int c) {
		if (r < N && r >= 0 && c < M && c >= 0) {
			return true;
		}
		return false;
	}

	static class Point {
		int r;
		int c;
		int dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
