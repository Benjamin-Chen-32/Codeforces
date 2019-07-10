import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CaesarLegion {
	
	static final long MOD = 100000000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N1 = Integer.parseInt(tk.nextToken());
		int N2 = Integer.parseInt(tk.nextToken());
		int K1 = Integer.parseInt(tk.nextToken());
		int K2 = Integer.parseInt(tk.nextToken());
		long[][] dpFoot = new long[N1 + N2 + 1][K1 + 1];
		long[][] dpHorse = new long[N1 + N2 + 1][K2 + 1];
		for (int i = 1; i <= N1 + N2; i++) {
			for (int j = 0; j <= K1; j++) {
				
			}
			for (int j = 0; j <= K2; j++) {
				
			}
		}
		long ans = 0;
		for (int i = 0; i <= K1; i++) {
			ans += dpFoot[N1 + N2][i] % MOD;
		}
		for (int i = 0; i <= K2; i++) {
			ans += dpHorse[N1 + N2][i] % MOD;
		}
		System.out.println(ans);
		in.close();
	}
}