import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OnePiece {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int x1 = Integer.parseInt(tk.nextToken());
		int y1 = Integer.parseInt(tk.nextToken());
		int x2 = Integer.parseInt(tk.nextToken());
		int y2 = Integer.parseInt(tk.nextToken());
		if (x1 == x2 || y1 == y2) {
			System.out.println(-1);
		} else {
			long area = Math.abs(((long) x1 - x2) * ((long) y1 - y2));
			System.out.println(area);
		}
		in.close();
	}
}
