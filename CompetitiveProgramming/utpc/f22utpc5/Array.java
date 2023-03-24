import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int q = Integer.parseInt(tk.nextToken());
		char[] str = in.readLine().toCharArray();
		BIT[] bits = new BIT[26];
		long mod = 1000000007;
		long[] factorials = new long[n / 2 + 3];
		factorials[0] = 1;
		for (int i = 1; i <= n / 2 + 2; i++) {
			factorials[i] = ((long) i * factorials[i - 1]);
		}
		for (int i = 0; i < 26; i++) {
			bits[i] = new BIT(n);
		}
		for (int i = 0; i < n; i++) {
			bits[str[i] - 'a'].update(i, 1);
		}
		for (int i = 0; i < q; i++) {
			tk = new StringTokenizer(in.readLine());
			int type = Integer.parseInt(tk.nextToken());
			if (type == 1) {
				int ind = Integer.parseInt(tk.nextToken());
				char c = tk.nextToken().toCharArray()[0];
				bits[c - 'a'].update(ind, 1);
				bits[str[ind] - 'a'].update(ind, -1);
				str[ind] = c;
			} else {
				int start = Integer.parseInt(tk.nextToken());
				int end = Integer.parseInt(tk.nextToken());
				int[] occurs = new int[26];
				int numOdd = 0;
				int oddChar = -1;
				int total = 0;
				for (int j = 0; j < 26; j++) {
					occurs[j] = bits[j].get(end) - bits[j].get(start - 1);
					if (occurs[j] % 2 == 1) {
						numOdd++;
						oddChar = j;
						if (numOdd > 1) {
							break;
						}
					}
					total += occurs[j];
				}
				if ((numOdd == 1 && total % 2 == 1) || numOdd == 0) {
					if (numOdd == 1 && total % 2 == 1) {
						total--;
						occurs[oddChar]--;
					}
					long pals = factorials[total / 2];
					for (int j = 0; j < 26; j++) {
						pals = pals / factorials[occurs[j] / 2];
					}
					System.out.println(pals % mod);
				} else {
					System.out.println(0);
				}
			}
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

		public BIT(int[] vals) {
			this(vals.length);
			for (int i = 0; i < vals.length; i++) {
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
