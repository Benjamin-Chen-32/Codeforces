import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeadMansChest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int[] nums = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(tk.nextToken());
			max = Math.max(max, nums[i]);
		}
		int gcd = nums[0];
		for (int x : nums) {
			gcd = gcd(gcd, x);
		}
		int maxElems = max / gcd;
		if ((maxElems - n) % 2 == 0) {
			System.out.println("Davy Jones");
		} else {
			System.out.println("Jack Sparrow");
		}
		in.close();
	}

	static int gcd(int a, int b) {
		int temp = 0;
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}