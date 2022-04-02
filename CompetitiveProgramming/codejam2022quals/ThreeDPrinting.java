import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeDPrinting {

	public static void solve(int[][] printers) {
		int[] mins = new int[4];
		for (int i = 0; i < 4; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				min = Math.min(min, printers[j][i]);
			}
			mins[i] = min;
		}
		int[] inks = new int[4];
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (sum + mins[i] >= 1000000) {
				inks[i] = 1000000 - sum;
				sum = 1000000;
				break;
			}
			inks[i] = mins[i];
			sum += mins[i];
		}
		if (sum < 1000000) {
			System.out.println("IMPOSSIBLE");
			return;
		}		
		for (int i = 0; i < 3; i++) {
			System.out.print(inks[i] + " ");
		}
		System.out.println(inks[3]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			int[][] printers = new int[3][4];
			for (int j = 0; j < 3; j++) {
				StringTokenizer tk = new StringTokenizer(in.readLine());
				for (int k = 0; k < 4; k++) {
					printers[j][k] = Integer.parseInt(tk.nextToken());
				}
			}
			solve(printers);
		}
		in.close();
	}
}
