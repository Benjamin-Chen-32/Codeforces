import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ppopgi {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(tk.nextToken());
		int y = Integer.parseInt(tk.nextToken());
		int r = Integer.parseInt(tk.nextToken());
		if (Math.min(x, y) >= 2 * r) {
			System.out.println("199");
		} else {
			System.out.println("067");
		}
		in.close();
	}
}
