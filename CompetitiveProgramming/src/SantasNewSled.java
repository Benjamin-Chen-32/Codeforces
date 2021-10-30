import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SantasNewSled {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		long x = Long.parseLong(tk.nextToken());
		long y = Long.parseLong(tk.nextToken());
		long xOffset = 0;
		long yOffset = 0;
		char[] s = in.readLine().toCharArray();
		in.close();
		for (char c : s) {
			switch (c) {
			case 'U':
				yOffset++;
				break;
			case 'D':
				yOffset--;
				break;
			case 'L':
				xOffset--;
				break;
			case 'R':
				xOffset++;
				break;
			}
		}
		long currX = 0;
		long currY = 0;
		// If x, y is a multiple of xOffset, yOffset
		if (isMult(x, y, xOffset, yOffset)) {
			System.out.println("Yes");
			return;
		}
		for (char c : s) {
			switch (c) {
			case 'U':
				currY++;
				break;
			case 'D':
				currY--;
				break;
			case 'L':
				currX--;
				break;
			case 'R':
				currX++;
				break;
			}
			// If x - currX, y - currY is a multiple of xOffset, yOffset
			long xDiff = x - currX;
			long yDiff = y - currY;
			if (isMult(xDiff, yDiff, xOffset, yOffset)) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}

	static boolean isMult(long x, long y, long xOffset, long yOffset) {
		if (xOffset == 0 && yOffset == 0) {
			return x == 0 && y == 0;
		} else if (xOffset == 0) {
			return x == 0 && y % yOffset == 0 && y / yOffset >= 0;
		} else if (yOffset == 0) {
			return y == 0 && x % xOffset == 0 && x / xOffset >= 0;
		}
		return x % xOffset == 0 && y % yOffset == 0 && x / xOffset == y / yOffset && x / xOffset >= 0;
	}
}
