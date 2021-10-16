package utpc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class PetPens1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		double[] heights = new double[N];
		double[] widths = new double[N];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine());
			heights[i] = Double.parseDouble(tk.nextToken());
			widths[i] = Double.parseDouble(tk.nextToken());
		}
		double totalArea = 0;
		for (int i = 0; i < N; i++) {
			double radiusSquared = Math.pow(heights[i] / 2, 2) + Math.pow(widths[i] / 2, 2);
			double area = Math.PI * radiusSquared;
			totalArea += area;
		}
		System.out.println(totalArea);
		in.close();
	}
}
