import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Tester {

	static int getRand(int low, int high) { // [low, high]
		Random random = new Random();
		return random.nextInt(high) + low;
	}

	public static void main(String[] args) throws IOException {
		//BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));

		int n = 5000;
		out.println(n);
		for (int i = 0; i < n; i++) {
			out.println(getRand(0, n));
		}
		out.close();
	}
}
