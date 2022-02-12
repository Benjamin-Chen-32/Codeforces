import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TugOfWar {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int[] strengths = new int[N];
		for (int i = 0; i < N; i++) {
			strengths[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(strengths);
		int a = 0;
		int b = 0;
		for (int i = 0; i < N / 2; i++) {
			b += strengths[i];
		}
		for (int i = N / 2; i < N; i++) {
			a += strengths[i];
		}
		double prob = (double) 1 / (1 + Math.pow(10, (double) (b - a) / 400));
		System.out.println(a + " " + prob);
		in.close();
	}
}
