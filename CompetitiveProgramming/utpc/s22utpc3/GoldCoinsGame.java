import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldCoinsGame {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(tk.nextToken());
		int y = Integer.parseInt(tk.nextToken());
		int moves = 0;
		while (y > x) {
			if (y % 3 != 0) {
				moves += 3 - (y % 3);
				y += 3 - (y % 3);
			}
			y /= 3;
			moves++;
		}
		moves += x - y;
		System.out.println(moves);
		in.close();
	}
}
