import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AirshipMerger {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(tk.nextToken());
		Stop[][] routes = new Stop[2][N];
		for (int i = 0; i < 2; i++) {
			tk = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				routes[i][j] = new Stop(Integer.parseInt(tk.nextToken()), j);
			}
		}
		Arrays.sort(routes[0]);
		Arrays.sort(routes[1]);
		int[] helper = new int[N];
		for (int i = 0; i < N; i++) {
			Stop stop1 = routes[0][i];
			Stop stop2 = routes[1][i];
			helper[stop2.ind] = stop1.ind;
		}
		System.out.println(LIS(helper));
		in.close();
	}

	static int LIS(int[] arr) {
		int[] tail = new int[arr.length];
		int length = 1;
		tail[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > tail[length - 1]) {
				tail[length++] = arr[i];
			} else {
				int ind = Arrays.binarySearch(tail, 0, length - 1, arr[i]);
				if (ind < 0) {
					ind = -1 * ind - 1;
				}
				tail[ind] = arr[i];
			}
		}
		return length;
	}

	static class Stop implements Comparable<Stop> {
		int num;
		int ind;

		public Stop(int num, int ind) {
			this.num = num;
			this.ind = ind;
		}

		@Override
		public int compareTo(Stop o) {
			return Integer.compare(this.num, o.num);
		}
	}
}
