import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Playlist {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		int[] playlist = new int[n];
		for (int i = 0; i < n; i++) {
			playlist[i] = Integer.parseInt(tk.nextToken());
		}
		HashSet<Integer> songs = new HashSet<Integer>();
		int ans = 0;
		int right = 0;
		for (int left = 0; left < n; left++) {
			while (right < n && !songs.contains(playlist[right])) {
				songs.add(playlist[right]);
				right++;
			}
			if (ans < right - left) ans = right - left;
			songs.remove(playlist[left]);
		}
		System.out.println(ans);
		in.close();
	}
}
