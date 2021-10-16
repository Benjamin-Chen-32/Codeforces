package utpc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BuggedSum {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int S = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(tk.nextToken());
			if (occurences.containsKey(a)) {
				occurences.put(a, occurences.get(a) + 1);
			} else {
				occurences.put(a, 1);
			}
			nums[i] = a;
		}
		in.close();
		for (int i = 0; i < N; i++) {
			int a = nums[i];
			int complement = S - a;
			if (a == complement && occurences.get(a) > 2) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}
}
