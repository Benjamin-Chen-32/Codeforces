import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrumbleGym {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int[] shakes = new int[n];
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			shakes[i] = Integer.parseInt(tk.nextToken());
		}
		int energy = 0;
		int set = m * (m + 1) / 2;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			energy += shakes[i];
			if (energy >= set) {
				ans++;
				energy = 0;
				set += m * m;
			}
		}
		System.out.println(ans);
		in.close();
	}
}
