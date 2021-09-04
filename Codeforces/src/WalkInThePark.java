import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WalkInThePark {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
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
		int[] offsetR = { 0, 0, 1, -1 };
		int[] offsetC = { 1, -1, 0, 0 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (obstacles[i][j]) {
					 continue;
				}
				
			}
		}
		in.close();
	}

	static void bfs(int startR, int startC, int endR, int endC) {
		LinkedList<Point> q = new LinkedList<Point>();
				q.add(new Point(startR, startC));
				while (!q.isEmpty()) {
					q.pop();
					for (int k = 0; k < 4; k++) {

					}
				}
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
		int dist = 0;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
