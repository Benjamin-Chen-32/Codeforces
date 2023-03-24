import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SledCircle {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] speeds = new int[n];
		for (int i = 0; i < n; i++) {
			speeds[i] = Integer.parseInt(tk.nextToken());
		}
		int[] positions = new int[n];
		for (int i = 0; i < n; i++) {
			positions[i] = i;
		}
		if (n == 1) {
			System.out.println("0 0");
			in.close();
			return;
		}
		for (int t = 1; t < 1001; t++) {
			int prevPositions = -1;
			boolean match = true;
			for (int i = 0; i < n; i++) {
				positions[i] += speeds[i];
				positions[i] %= n;
				if (prevPositions != -1 && positions[i] != prevPositions) {
					match = false;
				}
				prevPositions = positions[i];
			}
			if (match) {
				System.out.println(t + " " + prevPositions);
				in.close();
				return;
			}
		}
		System.out.println(-1);
		in.close();
	}
}
