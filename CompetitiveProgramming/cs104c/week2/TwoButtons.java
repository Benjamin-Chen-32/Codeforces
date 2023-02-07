import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TwoButtons {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		boolean[] vis = new boolean[20001];
		LinkedList<State> q = new LinkedList<State>();
		q.add(new State(n, 0));

		while (!q.isEmpty()) {
			State cur = q.poll();
			vis[cur.x] = true;
			if (cur.x == m) {
				System.out.println(cur.count);
				break;
			}
			if (cur.x > 0 && !vis[cur.x - 1]) {
				q.add(new State(cur.x - 1, cur.count + 1));
			}
			if (cur.x < m && !vis[cur.x * 2]) {
				q.add(new State(cur.x * 2, cur.count + 1));
			}

		}
		in.close();
	}

	static class State {
		int x;
		int count;

		public State(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
}
