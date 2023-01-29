import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GregAndArray {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());

		tk = new StringTokenizer(in.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}

		Op[] ops = new Op[m];
		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(tk.nextToken()) - 1;
			int r = Integer.parseInt(tk.nextToken()) - 1;
			int d = Integer.parseInt(tk.nextToken());
			ops[i] = new Op(l, r, d);
		}
		
		long[] opDiffs = new long[m + 1];
		for (int i = 0; i < k; i++) {
			tk = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(tk.nextToken()) - 1;
			int y = Integer.parseInt(tk.nextToken()) - 1;
			opDiffs[x]++;
			opDiffs[y + 1]--;
		}

		long[] arrDiffs = new long[n + 1];
		long times = 0;
		for (int i = 0; i < m; i++) {
			times += opDiffs[i];
			Op currOp = ops[i];
			arrDiffs[currOp.l] += times * currOp.d;
			arrDiffs[currOp.r + 1] -= times * currOp.d;
		}

		long diff = 0;
		for (int i = 0; i < n; i++) {
			diff += arrDiffs[i];
			arr[i] += diff;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
			if (i < n - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
		in.close();
	}

	static class Op {
		int l;
		int r;
		int d;

		public Op(int l, int r, int d) {
			this.l = l;
			this.r = r;
			this.d = d;
		}
	}
}
