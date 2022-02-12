import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarmensCustomMnMs {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long ans = 0;
		long nCk = 1;
		for (int k = 0; k <= n; k++) {
			if (!(k < 2 || (n - k) < 1)) {
				ans = (ans + nCk) % 1000000009;
			}
			nCk = nCk * ((n - k) % 1000000009) / (k + 1);
			nCk %= 1000000009;
		}
		System.out.println(ans);
		in.close();
	}
}
