import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SledTracks {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] locations = new int[N];
		for (int i = 0; i < N; i++) {
			locations[i] = Integer.parseInt(in.readLine());
		}
		int totalDamage = 0;
		for (int i = 1; i < N; i++) {
			totalDamage += Math.abs(locations[i] - locations[i - 1]);
		}
		System.out.println(totalDamage);
		in.close();
	}
}
