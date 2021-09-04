import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbhilashsCat {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name = in.readLine();
		long product = 1;
		long mod = 1000000000 + 7;
		for (int i = 0; i < name.length(); i++) {
			int value = name.charAt(i) - 'a' + 1;
			product = (product * value) % mod;
		}
		System.out.println(product % mod);
		in.close();
	}
}
