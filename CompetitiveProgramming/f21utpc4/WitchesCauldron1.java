import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WitchesCauldron1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int[] essences = new int[N];
		long totalVol = 0;
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			essences[i] = Integer.parseInt(tk.nextToken());
			totalVol += essences[i];
		}
		long low = 1;
		long high = totalVol;
		while (low < high) {
			long mid = (low + high) / 2;
			long currVol = 0;
			int cycle = 1;
			for (int i = 0; i < N; i++) {
				if (currVol + essences[i] > mid) {
					cycle++;
					currVol = essences[i];
				} else {
					currVol += essences[i];
				}
				if (cycle > K) {
					break;
				}
			}
			if (cycle > K) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		System.out.println(low);
		in.close();
	}
}
