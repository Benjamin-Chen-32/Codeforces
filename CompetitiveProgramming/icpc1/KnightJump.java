import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class KnightJump {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		boolean[][] board = new boolean[N][N];
		Point start = new Point(0, 0);
		for (int i = 0; i < N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = line[j] == '.' || line[j] == 'K';
				if (line[j] == 'K') {
					start = new Point(i, j);
				}
			}
		}
		LinkedList<Point> q = new LinkedList<Point>();
		int[][] dists = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dists[i], -1);
		}
		q.add(start);
		dists[start.r][start.c] = 0;
		int[] rOffset = { 2, 2, -2, -2, 1, 1, -1, -1 };
		int[] cOffset = { 1, -1, 1, -1, 2, -2, 2, -2 };
		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int i = 0; i < 8; i++) {
				int newR = curr.r + rOffset[i];
				int newC = curr.c + cOffset[i];
				if (inBounds(newR, newC, N, N) && board[newR][newC]) {
					if (dists[newR][newC] == -1) {
						dists[newR][newC] = dists[curr.r][curr.c] + 1;
						q.add(new Point(newR, newC));
					}
				}
			}
		}
		System.out.println(dists[0][0]);
		in.close();
	}

	static boolean inBounds(int r, int c, int R, int C) {
		if (r < R && r >= 0 && c < C && c >= 0) {
			return true;
		}
		return false;
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
