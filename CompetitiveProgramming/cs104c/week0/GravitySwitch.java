import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GravitySwitch {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] cubes = new int[n];
		for (int i = 0; i < n; i++) {
			cubes[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(cubes);
		for (int i = 0; i < n; i++) {
			System.out.print(cubes[i]);
			if (i < n - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
		in.close();
	}
}
