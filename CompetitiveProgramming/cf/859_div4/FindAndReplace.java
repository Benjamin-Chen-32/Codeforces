import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(tk.nextToken());
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(in.readLine());
			char[] s = in.readLine().toCharArray();
			boolean works = true;
			outer:
			for (int i = 0; i < 26; i++) {
				char curr = (char) ('a' + i);
				boolean first = false;
				int ind = 0;
				for (int j = 0; j < n; j++) {
					if (s[j] == curr) {
						if (first) {
							if ((j - ind) % 2 != 0) {
								works = false;
								break outer;
							}
						} else {
							first = true;
							ind = j;
						}
					}
				}
			}
			if (works) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}
}
