import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CelestialSky {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int q = Integer.parseInt(tk.nextToken());
		int[][] stars = new int[1000][1000];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			stars[a][b]++;
		}

		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			for (int r = Math.max(0, a - 1); r <= Math.min(999, a + 1); r++) {
				for (int c = Math.max(0, b - 1); c <= Math.min(999, b + 1); c++) {
					stars[r][c] = 0;
				}
			} 
		}

		int[][] prefix = new int[1001][1001];
		for (int i = 1; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				prefix[i][j] = stars[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
			}
		}
		for (int i = 0; i < q; i++) {
			tk = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int x2 = Integer.parseInt(tk.nextToken());
			int y2 = Integer.parseInt(tk.nextToken());

			int x3 = Math.max(x1, x2);
			int y3 = Math.max(y1, y2);
			int x4 = Math.min(x1, y1);
			int y4 = Math.min(y1, y2);

			int ans = prefix[x3 + 1][y3 + 1] - prefix[x3 + 1][y4] - prefix[x4][y3 + 1] + prefix[x4][y4];
			out.println(ans);
		}
		in.close();
		out.close();
	}
}