import java.util.Scanner;

public class NextRound {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int score = 1;
		int i;
		int numZeros = 0;
		for (i = 0; i < N; i++) {
			int s = in.nextInt();
			if (i == K - 1) {
				score = s;
			} else if (s < score || s == 0) {
				in.close();
				break;
			}
			if (s == 0) {
				numZeros++;
			}
		}
		System.out.println(i - numZeros);
		in.close();
	}
}