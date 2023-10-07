import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HattersParty {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		int[] strands = new int[n];
		for (int i = 0; i < n; i++) {
			strands[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(strands);
		int num_dishes = n / k;
		long sum = 0;
		for (int i = 0; i < num_dishes; i++) {
			sum += strands[n - i - 1];
		}
		out.println(sum);
		in.close();
		out.close();
	}
}