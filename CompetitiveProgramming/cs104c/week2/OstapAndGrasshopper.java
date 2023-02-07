import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class OstapAndGrasshopper {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		char[] board = in.readLine().toCharArray();
		boolean[] vis = new boolean[n];
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (board[i] == '#') {
				vis[i] = true;
			} else if (board[i] == 'G') {
				vis[i] = true;
				start = i;
			} else if (board[i] == 'T') {
				end = i;
			}
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(start);
		boolean found = false;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == end) {
				System.out.println("YES");
				found = true;
				break;
			}
			vis[curr] = true;
			if (curr + k < n && !vis[curr + k]) {
				q.add(curr + k);
			}
			if (curr - k >= 0 && !vis[curr - k]) {
				q.add(curr - k);
			}
		}
		if (!found) {
			System.out.println("NO");
		}
		in.close();
	}
}
