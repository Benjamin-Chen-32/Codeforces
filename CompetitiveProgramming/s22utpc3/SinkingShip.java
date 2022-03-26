import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SinkingShip {

	static BufferedReader in;
	static HashMap<Query, Integer> map;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<Query, Integer>();
		int n = Integer.parseInt(in.readLine());
		int maxRoom = binSearch(n, 0, n - 1);
		int lRoom = 0;
		int rRoom = 0;
		if (maxRoom - 1 >= 0 && (maxRoom + 1 >= n || query(0, maxRoom - 1) == n - 1)) {
			lRoom = binSearch(n - 1, 0, maxRoom - 1);
			System.out.println("! " + (lRoom + 1));
		} else {
			rRoom = binSearch(n - 1, maxRoom + 1, n - 1);
			System.out.println("! " + (rRoom + 1));
		}
		in.close();
	}

	static int binSearch(int val, int l, int r) throws IOException {
		while (l < r) {
			int mid = (l / 2) + (r / 2) + ((l % 2 + r % 2) / 2);
			int maxL = query(l, mid);
			if (maxL == val) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	static int query(int l, int r) throws IOException {
		Query q = new Query(l, r);
		if (map.containsKey(q)) {
			return map.get(q);
		} else {
			System.out.println("? " + (l + 1) + " " + (r + 1));
			int ans = Integer.parseInt(in.readLine());
			map.put(q, ans);
			return ans;
		}
	}

	static class Query {
		int l;
		int r;

		public Query(int l, int r) {
			this.l = l;
			this.r = r;
		}

		@Override
		public int hashCode() {
			int hash = l * 10000000;
			hash += r;
			return Integer.hashCode(hash);
		}

		@Override
		public boolean equals(Object other) {
			Query o = (Query) other;
			return this.l == o.l && this.r == o.r;
		}
	}
}
