import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GlobeLine {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] ticket = new int[N];
		for (int i = 0; i < N; i++) {
			ticket[i] = Integer.parseInt(in.readLine());
		}
		System.out.println(N);
		in.close();
	}
}
