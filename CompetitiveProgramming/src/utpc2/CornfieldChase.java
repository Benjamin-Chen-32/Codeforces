package utpc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CornfieldChase {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		boolean[][] cornstalks = new boolean[N][M];
		int[] rows = new int[N];
		int[] cols = new int[M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == '*') {
					cornstalks[i][j] = true;
					rows[i]++;
					cols[j]++;
				}
			}
		}

		long numTriangles = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cornstalks[i][j]) {
					numTriangles += (rows[i] - 1) * (cols[j] - 1);
				}

			}
		}
		System.out.println(numTriangles);
		in.close();
	}
}
