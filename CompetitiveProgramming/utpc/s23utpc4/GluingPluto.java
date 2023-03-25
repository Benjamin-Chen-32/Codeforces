import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GluingPluto {

	static int ans = Integer.MAX_VALUE;

	static void dfs(int[][] costs, int n, int curr, int currCost, int trav, boolean[] vis) {
		if (curr == 0) {
			if (trav == n) ans = Math.min(ans, currCost);
			return;
		}
		if (curr == -1) {
			curr = 0;
		}
		if (currCost >= ans) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i == curr || vis[i]) continue;
			vis[i] = true;
			dfs(costs, n, i, currCost + costs[curr][i], trav + 1, vis);
			vis[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int[][] costs = new int[n][n];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				costs[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		boolean[] vis = new boolean[n];
		dfs(costs, n, -1, 0, 0, vis);
		out.println(ans);
		in.close();
		out.close();
	}
}