import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDivision {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
			sum += arr[i];
		}
		System.out.println(bSearch(arr, sum, k));
		in.close();
	}

	static long bSearch(int[] arr, long sum, int k) {
		// First element that satisfies condition or arr.length if doesn't exist
		long l = 0L;
		long r = sum;
		while (l < r) {
			long mid = (l / 2L) + (r / 2L) + ((l % 2L + r % 2L) / 2L);
			if (works(arr, mid, k)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	static boolean works(int[] arr, long maxAllowed, int k) {
		int interval = 1;
		long curr = 0;
		for (int i = 0; i < arr.length; i++) {
			if (curr + arr[i] > maxAllowed) {
				curr = 0;
				interval++;
			}
			curr += arr[i];
			if (interval > k || arr[i] > maxAllowed) {
				return false;
			}
		}
		return true;
	}
}
