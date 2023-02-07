import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class MovieNight {

	static final int mod = 1000000007;
	static void compute(
		LinkedList<Integer>[] incoming,
		int[] mappings,
		long[] ans,
		int u
	) {
		long a = 1;
		for (int v : incoming[mappings[u]]) {
			if (mappings[u]==mappings[v]) continue;
			compute(incoming,mappings,ans,mappings[v]);
			a = a * (ans[mappings[v]] + 1) % mod;
		}
		ans[u] = a;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		LinkedList<Integer>[] incoming = new LinkedList[n];
		int[] tails = new int[n];
		Arrays.fill(tails, -1);
		for (int i = 0; i < n; i++) {
			incoming[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine()) - 1;
			incoming[arr[i]].add(i);
		}
		// System.out.println(Arrays.toString(incoming));
		int[] groups = new int[n];
		Arrays.fill(groups, -1);
		int group = 0;
		int pureCycles = 0;
		for (int i = 0; i < n; i++) {
			if (groups[i] != -1) continue;
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(i);
			boolean hasTail = false;
			while (!q.isEmpty()) {
				int curr = q.poll();
				groups[curr] = group;
				if (groups[arr[curr]] == -1) {
					q.add(arr[curr]);
				}
				if (incoming[curr].isEmpty()) {
					tails[group] = curr;
					hasTail = true;
				}
				for (int inc : incoming[curr]) {
					if (groups[inc] == -1) {
						q.add(inc);
					}
				}
			}
			if (!hasTail) {
				pureCycles++;
			}
			group++;
		}
		long ans = 1;
		boolean[] vis = new boolean[n];
		int[] mappings = new int[n];
		for (int i = 0; i < n; i++) {
			mappings[i] = i;
		}
		LinkedList<Integer> masters = new LinkedList<Integer>();
		for (int t : tails) {
			if (t == -1) continue;
			int curr = t;
			while (!vis[arr[curr]]) {
				vis[curr] = true;
				curr = arr[curr];
			}
			int master = arr[curr];
			curr = master;
			while (arr[curr] != master) {
				mappings[curr] = master;
				curr = arr[curr];
			}
			mappings[curr] = master;
			masters.add(master);
		}
		
		long[] Ans = new long[n];
		long a = 1;
		for (int master : masters) {
			compute(incoming,mappings,Ans,master);
			a=a*(Ans[master]+1)%mod;
		}
		// System.out.println(Arrays.toString(Ans));
		// System.out.println(a);
		ans=a;


		for (int i = 0; i < pureCycles; i++) {
			ans = (2L * ans) % mod;
		}

		if (ans == 0) {
			ans = mod;
		}
		System.out.println(ans - 1);
		in.close();
	}
}