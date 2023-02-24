import java.util.Arrays;

public class DataStructures {
	static class BIT { // Yosupo verified
		// Usable for associative and invertible operations
		// Lower const factor for memory than segtree
		int[] BIT;
		int N;

		public BIT(int N) {
			this.N = N;
			BIT = new int[N + 1];
		}

		public BIT(int[] vals) { // O(NlogN)
			this(vals.length);
			for (int i = 0; i < vals.length; i++) {
				this.update(i, vals[i]);
			}
		}

		// Sums from 0 to index inclusive
		// Note: summing from i to j inclusive is
		// bit.get(j) - (i == 0 ? 0 : bit.get(i))
		public int get(int index) { // O(logN)
			int sum = 0;
			index++;
			while (index > 0) {
				sum += BIT[index]; // Operation
				index -= index & (-index);
			}
			return sum;
		}

		public void update(int index, int val) { // O(logN)
			index++;
			while (index <= N) {
				BIT[index] += val; // Operation
				index += index & (-index);
			}
		}
	}

	static class DisjointSet { // Yosupo verified
		int[] arr;
		int[] size;
		int N;

		public DisjointSet(int N) { // O(N)
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

		public boolean find(int a, int b) { // O(logN)
			if (root(a) == root(b)) {
				return true;
			}
			return false;
		}

		public void union(int a, int b) { // O(logN)
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

	static class SegTree { // Yosupo verified
		// Usable for associative operations
		// For range update queries

		private int size;
		private int[] tree;
		private int[] lazy;
		private int[] sz;

		SegTree(int size) {
			this(size, new int[size]);
		}

		SegTree(int size, int[] val) {
			this.size = size;
			this.tree = new int[2 * size];
			this.lazy = new int[2 * size];
			this.sz = new int[2 * size];
			for (int i = 0; i < size; i++) {
				tree[size + i] = val[i];
				sz[size + i] = 1;
			}
			build();
		}

		private void build() {
			for (int i = 2 * size - 1; i > 1; i -= 2) {
				tree[i >> 1] = tree[i] + tree[i ^ 1]; // Operation
				sz[i >> 1] = sz[i] + sz[i ^ 1];
			}
		}

		// Update range from lo to hi inclusive
		public void update(int lo, int hi, int val) { // O(logN)
			for (int l = lo + size, r = hi + size; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
				if ((l & 1) > 0) {
					// Operation
					tree[l] += val * sz[l];
					lazy[l] += val;
				}
				if ((r & 1) == 0) {
					// Operation
					tree[r] += val * sz[r];
					lazy[r] += val;
				}
			}
			pushUp(lo + size);
			pushUp(hi + size);
		}

		private void pushUp(int i) {
			for (; i > 1; i >>= 1) {
				// Operation
				tree[i >> 1] = tree[i] + tree[i ^ 1] + lazy[i >> 1] * sz[i >> 1];
			}
		}

		// Query from lo to hi inclusive
		public int query(int lo, int hi) { // O(logN)
			int sum = 0;
			for (lo += size, hi += size; lo <= hi; lo = (lo + 1) >> 1, hi = (hi - 1) >> 1) {
				if ((lo & 1) > 0) {
					sum += getValue(lo); // Operation
				}
				if ((hi & 1) == 0) {
					sum += getValue(hi); // Operation
				}
			}
			return sum;
		}

		public int getValue(int i) {
			int res = tree[i];
			for (int j = i >> 1; j > 0; j >>= 1) {
				res += lazy[j] * sz[i]; // Operation
			}
			return res;
		}
	}
}
