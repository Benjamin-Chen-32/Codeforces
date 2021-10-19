import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbhilashsDog {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());
		int[] times = new int[N];
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(in.readLine());
		}
		int tasksCompleted = 0;
		int minutesUsed = 0;
		for (int i = 0; i < N; i++) {
			int timeCurrTask = times[i];
			if (minutesUsed + timeCurrTask > M) {
				break;
			}
			tasksCompleted++;
			minutesUsed += timeCurrTask;
		}
		System.out.println(tasksCompleted);
		in.close();
	}
}
