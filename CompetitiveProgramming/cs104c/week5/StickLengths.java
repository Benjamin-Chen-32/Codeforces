import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr);
		int median = arr.length % 2 == 0 ? (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2 : arr[arr.length / 2];
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.abs(arr[i] - median);
		}
		System.out.println(ans);
		in.close();
	}
}
