import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProtectSheep {
	
	static final int[] dirR = { 0, 0, 1, -1 };
	static final int[] dirC = { 1, -1, 0, 0 };

	static boolean inBounds(int r, int c, int R, int C) {
		if (r < R && r >= 0 && c < C && c >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		char[][] grid = new char[r][c];
		for (int i = 0; i < r; i++) {
			grid[i] = in.readLine().toCharArray();
		}
		boolean possible = true;
		outer:
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 'W') {
					for (int k = 0; k < 4; k++) {
						int newR = i + dirR[k];
						int newC = j + dirC[k];
						if (inBounds(newR, newC, r, c) && grid[newR][newC] == 'S') {
							possible = false;
							break outer;
						}
					}
				}
			}
		}
		if (!possible) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (grid[i][j] == '.') {
						System.out.print("D");
					} else {
						System.out.print(grid[i][j]);
					}
				}
				System.out.println();
			}
		}
		in.close();
	}
}
