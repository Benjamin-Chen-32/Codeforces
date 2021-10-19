import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrashBins {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			String line = in.readLine();
			boolean[] trashBins = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (line.charAt(i) == '1') {
					trashBins[i] = true;
				}
			}
			int[] distances = new int[N];
			for (int i = 0; i < N; i++) {
				distances[i] = Integer.MAX_VALUE;
			}
			int currTrash = -1;
			for (int i = 0; i < N; i++) {
				if (trashBins[i]) {
					currTrash = i;
				}
				if (currTrash != -1) {
					distances[i] = i - currTrash;
				}
			}
			currTrash = -1;
			for (int i = N - 1; i >= 0; i--) {
				if (trashBins[i]) {
					currTrash = i;
				}
				if (currTrash != -1) {
					distances[i] = Math.min(distances[i], currTrash - i);
				}
			}
			long totalDist = 0;
			for (int i = 0; i < N; i++) {
				totalDist += distances[i];
			}
			System.out.print("Case #" + (t + 1) + ": " + totalDist);
			if (t != T - 1) {
				System.out.print("\n");
			}
		}
		in.close();
	}
}
