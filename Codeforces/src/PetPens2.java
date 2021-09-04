import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PetPens2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int biggestRotatedHeight = 0;
		long totalWidth = 0;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine());
			int height = Integer.parseInt(tk.nextToken());
			int width = Integer.parseInt(tk.nextToken());
			if (width > height) {
				int origWidth = width;
				width = height;
				height = origWidth;
			}
			biggestRotatedHeight = Math.max(biggestRotatedHeight, height);
			totalWidth += width;
		}
		System.out.println(Math.max(totalWidth, biggestRotatedHeight));
		in.close();
	}
}
