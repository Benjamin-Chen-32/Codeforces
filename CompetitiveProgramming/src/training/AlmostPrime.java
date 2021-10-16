package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlmostPrime {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int almostPrimes = 0;
		for (int i = 1; i <= N; i++) {
			int num = i;
			int numFactors = 0;
			for (int j = 2; j <= num; j++) {
				if (num % j == 0) {
					numFactors++;
				}
				while (num % j == 0) {
					num /= j;
				}
			}
			if (numFactors == 2) {
				almostPrimes++;
			}
		}
		System.out.println(almostPrimes);
		in.close();
	}
}