import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class OwlDefense {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int front = Integer.parseInt(tk.nextToken());
		int back = Integer.parseInt(tk.nextToken());
		int[] frontTimes = new int[front];
		int[] backTimes = new int[back];
		
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < front; i++) {
			frontTimes[i] = Integer.parseInt(tk.nextToken());
		}

		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < back; i++) {
			backTimes[i] = Integer.parseInt(tk.nextToken());
		}

		HashSet<Integer> times = new HashSet<Integer>();
		for (int i = 0; i < front; i++) {
			times.add(frontTimes[i]);
		}

		for (int i = 0; i < back; i++) {
			if (times.contains(backTimes[i])) {
				System.out.println("You Lose");
				in.close();
				return;
			}
		}
		System.out.println("You Win");
		in.close();
	}
}
