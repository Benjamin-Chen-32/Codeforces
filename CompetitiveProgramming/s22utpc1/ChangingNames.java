import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChangingNames {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int[][] os = new int[n][26];
		int[][] wordOs = new int[26][m + 1];
		for (int i = 0; i < n; i++) {
			char[] name = in.readLine().toCharArray();
			for (char ch : name) {
				os[i][ch - 'a']++;
				os[i][ch - 'a'] = Math.min(os[i][ch - 'a'], m);
			}
			for (int j = 0; j < 26; j++) {
				wordOs[j][os[i][j]]++;
			}
		}
		int[][] postFix = new int[26][m + 1];
		for (int i = 0; i < 26; i++) {
			postFix[i][m] = wordOs[i][m];
			for (int j = m - 1; j >= 0; j--) {
				postFix[i][j] = wordOs[i][j] + postFix[i][j + 1];
			}
		}
		int[] uses = new int[26];
		int[] dp = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			dp[i] = dp[i - 1];
			int score = 0;
			int best = 0;
			for (int j = 0; j < 26; j++) {
				int use = uses[j] + 1;
				if (postFix[j][use] > score) {
					score = postFix[j][use];
					best = j;
				}
			}
			uses[best]++;
			dp[i] += score;
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < uses[i]; j++) {
				char ch = (char) (i + 'a');
				System.out.print(ch);
			}
		}
		System.out.println();
		in.close();
	}
}
