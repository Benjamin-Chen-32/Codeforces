package utpc4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FeedingTheEarthKingdom {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		DisjointSet ds = new DisjointSet(N);
		HashSet<Integer> islands = new HashSet<Integer>();
		int numIslands = 0;
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			ds.union(a, b);
		}
		for (int i = 0; i < N; i++) {
			int root = ds.root(i);
			if (!islands.contains(root)) {
				numIslands++;
				islands.add(root);
			}
		}
		System.out.println(numIslands);
		in.close();
	}

	static class DisjointSet {
		int[] arr;
		int[] size;
		int N;

		public DisjointSet(int N) {
			this.N = N;
			arr = new int[N];
			size = new int[N];
			Arrays.fill(size, 1);
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}
		}

		public int root(int curr) {
			while (arr[curr] != curr) {
				arr[curr] = arr[arr[curr]];
				curr = arr[curr];
			}
			return curr;
		}

		public boolean find(int a, int b) {
			if (root(a) == root(b)) {
				return true;
			}
			return false;
		}

		public void union(int a, int b) {
			int aRoot = root(a);
			int bRoot = root(b);
			if (size[aRoot] < size[bRoot]) {
				// Subset B is bigger than subset A, so B should be A's parent
				arr[aRoot] = arr[bRoot];
				size[bRoot] += size[aRoot];
			} else {
				arr[bRoot] = arr[aRoot];
				size[aRoot] += size[bRoot];
			}
		}
	}
}
