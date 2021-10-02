package utpc4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AirMoped {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(tk.nextToken());
		int numLattice = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= R; j++) {
				int kLow = (int) Math.sqrt(R * R - i * i - j * j);
				for (int k = kLow; k <= kLow + 1; k++) {
					if (k == 0) {
						continue;
					}
					if (i * i + j * j + k * k == R * R) {
						numLattice++;
					}
				}
			}
		}
		int latticeEdges = 0;
		for (int j = -R; j <= R; j++) {
			int kLow = (int) Math.sqrt(R * R - j * j);
			for (int k = -kLow - 1; k <= kLow + 1; k++) {
				if (j * j + k * k == R * R) {
					latticeEdges++;
				}
			}
		}
		for (int i = -R; i <= R; i++) {
			int kLow = (int) Math.sqrt(R * R - i * i);
			for (int k = -kLow - 1; k <= kLow + 1; k++) {
				if (i * i + k * k == R * R) {
					latticeEdges++;
				}
			}
		}
		for (int i = -R; i <= R; i++) {
			for (int j = -R; j <= R; j++) {
				if (i * i + j * j == R * R) {
					latticeEdges++;
				}
			}
		}
		System.out.println(numLattice * 8 + latticeEdges - 6);
		in.close();
	}
}
