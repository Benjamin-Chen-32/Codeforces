import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InterestingDrink {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(prices);
		int q = Integer.parseInt(in.readLine());
		for (int i = 0; i < q; i++) {
			int coins = Integer.parseInt(in.readLine());

			int bound = upperBound(prices, coins);
			System.out.println(bound);
		}
		in.close();
	}

	static int upperBound(int[] arr, int value) {
		// First element which is > val
		int l = 0;
		int r = arr.length;
		while (l < r) {
			int mid = (l / 2) + (r / 2) + ((l % 2 + r % 2) / 2);
			if (value >= arr[mid]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}
}
