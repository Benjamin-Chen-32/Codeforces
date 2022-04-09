import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BirdWatching {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		long n = Integer.parseInt(tk.nextToken());
		long m = Integer.parseInt(tk.nextToken());
		SegmentTreeNonrecursive tree = new SegmentTreeNonrecursive(100001);
		for (long i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			tree.update(a, b, 1);
		}
		for (long i = 0; i < m; i++) {
			tk = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(tk.nextToken());
			int d = Integer.parseInt(tk.nextToken());
			System.out.println(tree.query(c, d));
		}
		in.close();
	}

	static class SegmentTreeNonrecursive {

		private int size;
		private long[] tree;
		private long[] lazy;
		private long[] sz;

		SegmentTreeNonrecursive(int size) {
			this(size, new long[size]);
		}

		SegmentTreeNonrecursive(int size, long[] val) {
			this.size = size;
			this.tree = new long[2 * size];
			this.lazy = new long[2 * size];
			this.sz = new long[2 * size];
			for (int i = 0; i < size; i++) {
				tree[size + i] = val[i];
				sz[size + i] = 1;
			}
			build();
		}

		private void build() {
			// building the tree from the initial values and initializing the size of each
			// segment
			for (int i = 2 * size - 1; i > 1; i -= 2) {
				tree[i >> 1] = tree[i] + tree[i ^ 1];
				sz[i >> 1] = sz[i] + sz[i ^ 1];
			}
		}

		public void update(int lo, int hi, long val) {
			// directly modifying the segments
			// note that a left child will have an even index while a right child will have
			// an odd index
			for (int l = lo + size, r = hi + size; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
				// if the left child is even, it is contained in a segment higher above, so we
				// can ignore it
				if ((l & 1) > 0) {
					tree[l] += val * sz[l];
					lazy[l] += val;
				}
				// if the right child is odd, it is contained in a segment higher above, so we
				// can ignore it
				if ((r & 1) == 0) {
					tree[r] += val * sz[r];
					lazy[r] += val;
				}
			}
			// updating the segments that contain the updated segment
			pushUp(lo + size);
			pushUp(hi + size);
		}

		public void pushUp(int i) {
			// we add the values of the child segments, but we also have the add the lazy
			// value for the entire segment length
			for (; i > 1; i >>= 1)
				tree[i >> 1] = tree[i] + tree[i ^ 1] + lazy[i >> 1] * sz[i >> 1];
		}

		public long query(int lo, int hi) {
			long sum = 0;
			for (lo += size, hi += size; lo <= hi; lo = (lo + 1) >> 1, hi = (hi - 1) >> 1) {
				// if the left child is even, it is contained in a segment higher above, so we
				// can ignore it
				if ((lo & 1) > 0) {
					sum += getValue(lo);
				}
				// if the right child is odd, it is contained in a segment higher above, so we
				// can ignore it
				if ((hi & 1) == 0) {
					sum += getValue(hi);
				}
			}
			return sum;
		}

		public long getValue(int i) {
			// a lower segment might be modified by a upper segment, so we add the lazy
			// values of the upper segments but traversing up the tree
			long res = tree[i];
			for (int j = i >> 1; j > 0; j >>= 1)
				res += lazy[j] * sz[i];
			return res;
		}
	}
}
