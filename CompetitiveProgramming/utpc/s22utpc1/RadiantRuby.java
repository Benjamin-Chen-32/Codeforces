import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RadiantRuby {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		boolean[] notLeaf = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			notLeaf[a] = true;
		}
		long numLeaves = 0;
		for (int i = 0; i < n; i++) {
			if (!notLeaf[i]) {
				numLeaves++;
			}
		}
		long ans = numLeaves * (numLeaves - 1) / 2;
		System.out.println(ans);
		in.close();
	}
}
