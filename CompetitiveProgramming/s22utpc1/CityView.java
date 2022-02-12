import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CityView {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		double[] angles = new double[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			double theta = Math.toDegrees(Math.atan2(y, x));
			if (theta < 0) {
				theta = 360 + theta;
			}
			angles[i] = theta;
		}
		Arrays.sort(angles);
		double maxDiff = 0;
		for (int i = 0; i < n - 1; i++) {
			double diff = angles[i + 1] - angles[i];
			maxDiff = Math.max(maxDiff, diff);
		}
		maxDiff = Math.max(maxDiff, angles[0] + 360 - angles[n - 1]);
		System.out.println(360 - maxDiff);
		in.close();
	}
}
