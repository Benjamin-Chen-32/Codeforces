import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class AttackOnTitans {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int[] wall1 = new int[n];
		HashSet<Integer> wall2 = new HashSet<Integer>();
		HashSet<Integer> wall3 = new HashSet<Integer>();
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			wall1[i] = Integer.parseInt(tk.nextToken());
		}
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			wall2.add(Integer.parseInt(tk.nextToken()));
		}
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			wall3.add(Integer.parseInt(tk.nextToken()));
		}
		int max = -1;
		for (int i = 0; i < n; i++) {
			if (wall2.contains(wall1[i]) && wall3.contains(wall1[i])) {
				max = Math.max(max, wall1[i]);
			}
		}
		out.println(max);
		in.close();
		out.close();
	}
}