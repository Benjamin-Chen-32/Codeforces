import java.util.*;
import java.io.*;

// https://www.spoj.com/problems/ADACLEAN/
// I'm passing the sample and a bunch of small cases I've written by hand... Can you help me?

public class AdaClean {
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numCases = in.nextInt();
		long mod1 = 1000000007;
		long mod2 = 1000000009;
		for (int t = 0; t < numCases; t++) {
			int unique = 1;
			int strLen = in.nextInt();
			int substrLen = in.nextInt();
			String s = in.next();

			// Store all the hashes of each substring of length K
			HashSet<Long> substrHashes = new HashSet<>();
			HashSet<Long> substrHashes2 = new HashSet<>();

			// compute the hash of the first K characters
			long hash = 0;
			long hash2 = 0;
			long biggest_power = 1;
			long biggest_power2 = 1;
			for (int i = 0; i < substrLen; i++) {
				// convert 'a'...'z' -> 1...27
				int letter = s.charAt(i) - 97;
				hash = (((27 * hash) % mod1) + letter) % mod1;
				hash2 = (((27 * hash2) % mod2) + letter) % mod2;
			}

			// compute 27^(K - 1)
			for (int i = 0; i < substrLen - 1; i++) {
				biggest_power = (biggest_power * 27) % mod1;
				biggest_power2 = (biggest_power2 * 27) % mod2;
			}

			substrHashes.add(hash);
			substrHashes2.add(hash2);

			// use sliding window to compute the other hashes
			for (int i = substrLen; i < strLen; i++) {
				// remove the leftmost letter
				int left_letter = s.charAt(i - substrLen) - 97;
				hash = hash - (left_letter * biggest_power) % mod1;
				hash2 = hash2 - (left_letter * biggest_power2) % mod2;
				if (hash < 0) {
					hash += mod1;
				}
				if (hash2 < 0) {
					hash2 += mod2;
				}

				// slide the window and add the new letter
				int right_letter = s.charAt(i) - 97;
				hash = (((27 * hash) % mod1) + right_letter) % mod1;
				hash2 = (((27 * hash2) % mod2) + right_letter) % mod2;

				// add hash to the set
				if (!substrHashes.contains(hash) || !substrHashes2.contains(hash2)) {
					unique++;
				}
				substrHashes.add(hash);
				substrHashes2.add(hash2);
			}
			out.println(unique);
		}
		out.flush();
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public String restLine() {
			String s = "";
			while (tokenizer.hasMoreTokens())
				s += tokenizer.nextToken() + " ";
			return s.trim();
		}
	}
}
