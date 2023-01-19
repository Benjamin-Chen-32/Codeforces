import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Robot {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		Num[] sort = new Num[n];
		int[] nums = new int[n];
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(tk.nextToken());
			sort[i] = new Num(nums[i], i);
		}
		Arrays.sort(sort);
		int max = 0;
		int robot = -1;
		int i = 0;
		boolean[] used = new boolean[n];
		int numPicked = 0;
		while (robot < n && numPicked < n) {
			Num cur = sort[i];
			while (cur.i <= robot) {
				i++;
				cur = sort[i];
			}
			max += cur.x;
			used[cur.i] = true;
			i++;
			robot++;
			numPicked += 2;
			while (robot < n && used[robot]) {
				robot++;
			}
		}
		System.out.println(max);
		in.close();
	}

	static class Num implements Comparable<Num> {
		int x;
		int i;

		public Num(int x, int i) {
			this.x = x;
			this.i = i;
		}

		@Override
		public int compareTo(Num o) {
			if (this.x == o.x) {
				return Integer.compare(this.i, o.i);
			}
			return Integer.compare(o.x, this.x);
		}
		
	}
}
