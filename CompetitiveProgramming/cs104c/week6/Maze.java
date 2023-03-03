import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.security.auth.kerberos.KerberosCredMessage;

public class Maze {

	static final int[] dirR = { 0, 0, 1, -1 };
	static final int[] dirC = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		boolean[][] wall = new boolean[n][m];
		boolean[][] orig = new boolean[n][m];
		int numEmpty = 0;
		Node start = new Node(0, 0);
		for (int i = 0; i < n; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (line[j] == '#') {
					wall[i][j] = true;
					orig[i][j] = true;
				} else {
					start.i = i;
					start.j = j;
					numEmpty++;
				}
			}
		}
		solve(wall, start, n, m, k, numEmpty);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (wall[i][j]) {
					if (orig[i][j]) {
						System.out.print("#");
					} else {
						System.out.print("X");
					}
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		in.close();
	}

	static void solve(boolean[][] grid, Node start, int n, int m, int k, int numEmpty) {
		boolean[][] visited = new boolean[n][m];
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		int numVis = 0;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (visited[curr.i][curr.j]) {
				continue;
			}
			visited[curr.i][curr.j] = true;
			numVis++;
			if (numEmpty - numVis == k) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int newR = curr.i + dirR[i];
				int newC = curr.j + dirC[i];
				if (inBounds(newR, newC, n, m) && !visited[newR][newC] && !grid[newR][newC]) {
					q.add(new Node(newR, newC));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && !grid[i][j]) {
					grid[i][j] = true;
				}
			}
		}
	}

	static boolean inBounds(int r, int c, int R, int C) {
		if (r < R && r >= 0 && c < C && c >= 0) {
			return true;
		}
		return false;
	}

	static class Node {
		int i;
		int j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
