import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TallestDogpark {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(in.readLine());
		if (L % 2 == 0) {
			L--;
		}
		int halfway = L / 2;
		System.out.println(halfway);
		in.close();
	}
}
