import java.io.*;
import java.util.*;

/*
 * The problem statement can be found at http://www.spoj.com/problems/AGGRCOW/
 *
 * The online judge gives TLE, but the sample test case works. Can you find the
 * bug?
 */
public class AggressiveCows {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numStalls = Integer.parseInt(st.nextToken());
			int numCows = Integer.parseInt(st.nextToken());

			int[] stallPositions = new int[numStalls];
			for (int i = 0; i < numStalls; i++) {
				stallPositions[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(stallPositions);
			System.out.println(solve(stallPositions, numCows));
		}
	}

	private static int solve(int[] stallPositions, int numCows) {

		int l = 0;
		int r = stallPositions[stallPositions.length - 1];
		while (l < r) {
			int mid = (l / 2) + (r / 2) + ((l % 2 + r % 2) / 2);
			if (!works(stallPositions, numCows, mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l - 1;
	}

	private static boolean works(int[] stallPositions, int numCows, int minDist) {
		int lastCowPosition = -minDist;
		for (int stallPosition : stallPositions) {
			if (numCows <= 0) {
				break;
			}
			if (stallPosition - lastCowPosition >= minDist) {
				lastCowPosition = stallPosition;
				numCows--;
			}
		}

		return numCows <= 0;
	}
}
