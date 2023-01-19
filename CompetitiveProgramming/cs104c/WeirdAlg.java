import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class WeirdAlg {
 
	static StringBuilder output = new StringBuilder("");
 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		long N = Long.parseLong(tk.nextToken());
		while (N != 1) {
			output.append(N + " ");
			if (N % 2 == 0) {
				N /= 2;
			} else {
				N = N * 3 + 1;
			}
		}
		output.append("1");
		System.out.println(output.toString());
		in.close();
	}
}