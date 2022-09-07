import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PenguinProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int t = Integer.parseInt(tk.nextToken());
		int d = Integer.parseInt(tk.nextToken());

		tk = new StringTokenizer(in.readLine());
		int[] strengths = new int[n];
		for (int i = 0; i < n; i++) {
			strengths[i] = Integer.parseInt(tk.nextToken());
		}
		BIT tree = new BIT(n, strengths);

		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < t; i++) {
			tk = new StringTokenizer(in.readLine());
			starts[i] = Integer.parseInt(tk.nextToken()) - 1;
			ends[i] = Integer.parseInt(tk.nextToken()) - 1;
		}

		for (int i = 0; i < d; i++) {
			tk = new StringTokenizer(in.readLine());
			int q = Integer.parseInt(tk.nextToken());
			for (int j = 0; j < q; j++) {
				int friend = Integer.parseInt(tk.nextToken()) - 1;
				tree.update(friend, 1);
			}
			System.out.print("Day " + (i + 1) + ": ");
			for (int j = 0; j < t; j++) {
				System.out.print((tree.get(ends[j]) - (starts[j] == 0 ? 0 : tree.get(starts[j] - 1))) + " ");
			}
			System.out.println();
		}
		in.close();
	}

	static class BIT {
		int[] BIT;
		int N;

		public BIT(int N) {
			this.N = N;
			BIT = new int[N + 1];
		}

		public BIT(int N, int[] vals) {
			this(N);
			for (int i = 0; i < N; i++) {
				this.update(i, vals[i]);
			}
		}

		public int get(int index) {
			int sum = 0;
			index++;
			while (index > 0) {
				sum += BIT[index];
				index -= index & (-index);
			}
			return sum;
		}

		public void update(int index, int val) {
			index++;
			while (index <= N) {
				BIT[index] += val;
				index += index & (-index);
			}
		}
	}
}