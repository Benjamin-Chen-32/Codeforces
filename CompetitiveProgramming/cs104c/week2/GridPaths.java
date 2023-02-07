import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPaths {

	static char[] moves;
	static int count;

	//static HashMap<State, Integer> dp;

	static final int[] dirR = { 0, 1, 0, -1 };
	static final int[] dirC = { 1, 0, -1, 0 };
	static final char[] trans = { 'R', 'D', 'L', 'U' };

	static boolean inBounds(int r, int c, int R, int C) {
		if (r < R && r >= 0 && c < C && c >= 0) {
			return true;
		}
		return false;
	}

	public static void gen(boolean[][] vis, int r, int c, int dist) {
		//State curr = new State(r, c, dist, vis);
		//if (dp.containsKey(curr)) {
		//	return dp.get(curr);
		//}
		if (r == 6 && c == 0) {
			if (dist == 48) {
				//dp.put(curr, 1);
				//return 1;
				count++;
				return;
			} else {
				//dp.put(curr, 0);
				//return 0;
				return;
			}
		}
		//int ret = 0;
		int[] valid = new int[4];
		int ind = 0;
		for (int i = 0; i < 4; i++) {
			int newR = r + dirR[i];
			int newC = c + dirC[i];
			if (inBounds(newR, newC, 7, 7) && !vis[newR][newC] && (moves[dist] == '?' || moves[dist] == trans[i])) {
				valid[ind] = i;
				ind++;
			}
		}
		// Case where you can't go forward, but you can turn left or right
		// You will split the board and it's guaranteed to not finish
		if (ind == 2) {
			if (valid[1] - valid[0] == 2) {
				return;
			}
		}
		// Potential dead ends
		if (c > 2 && r > 0 && r < 6 && vis[r][c - 2] && (vis[r + 1][c - 1] || vis[r - 1][c - 1]) && !vis[r][c - 1] && (moves[dist] == '?' || moves[dist] == 'L')) {
			// Left
			vis[r][c - 1] = true;
			gen(vis, r, c - 1, dist + 1);
			vis[r][c - 1] = false;
		} else if (c < 5 && r > 0 && r < 6 && vis[r][c + 2] && (vis[r + 1][c + 1] || vis[r - 1][c + 1]) && !vis[r][c + 1] && (moves[dist] == '?' || moves[dist] == 'R')) {
			// Right
			vis[r][c + 1] = true;
			gen(vis, r, c + 1, dist + 1);
			vis[r][c + 1] = false;
		} else if (r < 5 && c > 0 && c < 6 && vis[r + 2][c] && (vis[r + 1][c + 1] || vis[r + 1][c - 1]) && !vis[r + 1][c] && (moves[dist] == '?' || moves[dist] == 'D')) {
			// Down
			vis[r + 1][c] = true;
			gen(vis, r + 1, c, dist + 1);
			vis[r + 1][c] = false;
		} else if (r > 2 && c > 0 && c < 6 && vis[r - 2][c] && (vis[r - 1][c + 1] || vis[r - 1][c - 1]) && !vis[r - 1][c] && (moves[dist] == '?' || moves[dist] == 'U')) {
			// Up
			vis[r - 1][c] = true;
			gen(vis, r - 1, c, dist + 1);
			vis[r - 1][c] = false;
		} else {
			for (int ind2 = 0; ind2 < ind; ind2++) {
				int i = valid[ind2];
				int newR = r + dirR[i];
				int newC = c + dirC[i];
				vis[newR][newC] = true;
				gen(vis, newR, newC, dist + 1);
				vis[newR][newC] = false;
			}
		}
		//dp.put(curr, ret);
		//return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		moves = in.readLine().toCharArray();
		boolean[][] vis = new boolean[7][7];
		vis[0][0] = true;
		//dp = new HashMap<State, Integer>();
		//int ans = gen(vis, 0, 0, 0);
		gen(vis, 0, 0, 0);
		System.out.println(count);
		in.close();
	}

	//public static class State {
	//	int r;
	//	int c;
	//	int dist;
	//	boolean[][] vis;

	//	public State(int r, int c, int dist, boolean[][] vis) {
	//		this.r = r;
	//		this.c = c;
	//		this.dist = dist;
	//		this.vis = vis;
	//	}

	//	@Override
	//	public int hashCode() {
	//		long visL = 0;
	//		for (int i = 0; i < 7; i++) {
	//			for (int j = 0; j < 7; j++) {
	//				if (vis[i][j]) {
	//					visL += 1 << (7 * i + j);
	//				}
	//			}
	//		}
	//		visL += r << 50;
	//		visL += c << 53;
	//		visL += dist << 56;
	//		return Long.hashCode(visL);
	//	}

	//	@Override
	//	public boolean equals(Object other) {
	//		State o = (State) other;
	//		if (r == o.r && c == o.c && dist == o.dist) {
	//			for (int i = 0; i < 7; i++) {
	//				for (int j = 0; j < 7; j++) {
	//					if (vis[i][j] != o.vis[i][j]) {
	//						return false;
	//					}
	//				}
	//			}
	//			return true;
	//		}
	//		return false;
	//	}
	//}
}
