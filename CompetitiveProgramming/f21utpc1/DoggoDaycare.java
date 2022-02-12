import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoggoDaycare {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		boolean[][] friendships = new boolean[5][5];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			friendships[a][b] = true;
			friendships[b][a] = true;
		}
		int max = 0;
		for (int i = 0; i < 5; i++) {
			max += 1 << i;
		}
		boolean happySet = false;
		for (int x = 0; x <= max; x++) {
			int[] currGroup = new int[3];
			int numDogs = 0;
			boolean invalid = false;
			for (int i = 0; i < 5; i++) {
				if ((x & (1 << i)) == 1 << i) {
					if (numDogs > 2) {
						invalid = true;
						break;
					}
					currGroup[numDogs] = i;
					numDogs++;
				}
			}
			if (numDogs != 3) {
				invalid = true;
			}
			if (invalid) {
				continue;
			}
			int numFriendships = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 3; j++) {
					if (friendships[currGroup[i]][currGroup[j]]) {
						numFriendships++;
					}
				}
			}
			if (numFriendships == 0 || numFriendships == 3) {
				happySet = true;
				break;
			}
		}
		System.out.println(happySet ? "Happy Doggos!" : "Sad Doggos...");
		in.close();
	}
}
