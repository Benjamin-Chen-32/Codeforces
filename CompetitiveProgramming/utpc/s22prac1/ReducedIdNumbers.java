import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReducedIdNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		for (int i = n; i <= Integer.MAX_VALUE; i++) {
			boolean[] used = new boolean[i];
			boolean works = true;
			for (int j = 0; j < n; j++) {
				int mod = nums[j] % i;
				if (used[mod]) {
					works = false;
					break;
				}
				used[mod] = true;
			}
			if (works) {
				System.out.println(i);
				break;
			}
		}
		in.close();
	}
}
