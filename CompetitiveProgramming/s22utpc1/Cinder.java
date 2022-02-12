import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Cinder {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		HashMap<String, Integer> db = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			if (!db.containsKey(s)) {
				System.out.println("OK");
				db.put(s, 1);
			} else {
				System.out.println(s + db.get(s));
				db.put(s, db.get(s) + 1);
			}
		}
		in.close();
	}
}