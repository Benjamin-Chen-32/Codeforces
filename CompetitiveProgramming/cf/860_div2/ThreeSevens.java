import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ThreeSevens {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine());
		outer:
		for (int test = 0; test < t; test++) {
			int m = Integer.parseInt(in.readLine());
			HashMap<Integer, Integer> lasts = new HashMap<Integer, Integer>();
			for (int i = 0; i < m; i++) {
				int n = Integer.parseInt(in.readLine());
				StringTokenizer tk = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					int participant = Integer.parseInt(tk.nextToken());
					lasts.put(participant, i);
				}
			}
			@SuppressWarnings("unchecked")
			LinkedList<Integer>[] lastsFlipped = new LinkedList[m];
			for (int i = 0; i < m; i++) {
				lastsFlipped[i] = new LinkedList<Integer>();
			}
			for (int part : lasts.keySet()) {
				lastsFlipped[lasts.get(part)].add(part);
			}
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < m; i++) {
				if (i != 0) {
					ans.append(" ");
				}
				if (lastsFlipped[i].isEmpty()) {
					out.println(-1);
					continue outer;
				} else {
					int x = lastsFlipped[i].peek();
					ans.append(x);
				}
			}
			out.println(ans);
		}
		in.close();
		out.close();
	}
}