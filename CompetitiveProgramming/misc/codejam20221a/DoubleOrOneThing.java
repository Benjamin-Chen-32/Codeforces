import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleOrOneThing {

	static void solve(char[] s) {
		int n = s.length;
		int repeat = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (s[i] == s[n - 1]) {
				repeat = i;
			} else {
				break;
			}
		}
		int i = 0;
		while (i < repeat) {
			int currRepeats = 1;
			while (s[i] == s[i + 1]) {
				currRepeats++;
				i++;
			}
			for (int j = 0; j < currRepeats; j++) {
				if (s[i] < s[i + 1]) {
					System.out.print(s[i]);
					System.out.print(s[i]);
				} else {
					System.out.print(s[i]);
				}
			}
			i++;
		}
		String str = new String(s);
		System.out.println(str.substring(repeat));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			String s = in.readLine();
			solve(s.toCharArray());
		}
		in.close();
	}
}
