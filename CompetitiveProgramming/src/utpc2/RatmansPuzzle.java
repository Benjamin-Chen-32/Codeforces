package utpc2;
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
		long max = 1L << K;
		long pairs = 0;
		for (long i = 0; i < max - 1; i++) {
			long xor = i ^ N;
			if (xor < max && xor > i) {
				pairs++;
			}
		}
		System.out.println(pairs);
		in.close();
	}
}
