import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PunchedCards {

	public static void horiz(int cols) {
		System.out.print("+");
		for (int c = 0; c < cols; c++) {
			System.out.print("-+");
		}
		System.out.println();
	}

	public static void row(int cols) {
		System.out.print("|");
		for (int c = 0; c < cols; c++) {
			System.out.print(".|");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int rows = Integer.parseInt(tk.nextToken());
			int cols = Integer.parseInt(tk.nextToken());
			System.out.println("Case #" + (i + 1) + ":");
			System.out.print("..");
			horiz(cols - 1);
			System.out.print("..");
			row(cols - 1);
			horiz(cols);
			for (int r = 1; r < rows; r++) {
				row(cols);
				horiz(cols);
			}
		}
		in.close();
	}
}
