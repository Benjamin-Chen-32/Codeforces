import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RatmansPuzzle {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		long N = Long.parseLong(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		if (N >= ((long) 1 << K)) {
			System.out.println(0);
		} else {
			System.out.println(((long) 1 << (K - 1)));
		}
		in.close();
	}
}
