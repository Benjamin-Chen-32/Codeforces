import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CivilWar {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tk.nextToken());
		}
		int currGCD = 0;
		for (int i = 0; i < N; i++) {
			if (currGCD == 1) {
				break;
			}
			currGCD = gcd(currGCD, nums[i]);
		}
		in.close();
		for (int i = 2; i <= (int) Math.sqrt(currGCD); i++) {
			if (isPower(i, currGCD)) {
				System.out.println(currGCD);
				return;
			}
		}
		System.out.println("NO CIVIL WAR");
	}

	static boolean isPower(int x, int y) {
		int roundedLog = (int) (Math.log(y) / Math.log(x));       
		double nonRoundedLog = Math.log(y) / Math.log(x);
		return roundedLog == nonRoundedLog;
	}

	static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
