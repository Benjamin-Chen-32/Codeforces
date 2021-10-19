import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JulietsGarden {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		while (N % 2 == 0) {
			N /= 2;
		}
		if (N == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		in.close();
	}
}
