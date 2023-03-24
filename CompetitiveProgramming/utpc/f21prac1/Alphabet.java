import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] line = in.readLine().toCharArray();
		int[] arr = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			arr[i] = line[i] - 'a';
		}
		System.out.println(26 - lis(arr));
		in.close();
	}

	static int lis(int[] arr) {
		int[] tail = new int[arr.length];
		int length = 1;
		tail[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > tail[length - 1]) {
				tail[length++] = arr[i];
			} else {
				int ind = Arrays.binarySearch(tail, 0, length - 1, arr[i]);
				if (ind < 0) {
					ind = -1 * ind - 1;
				}
				tail[ind] = arr[i];
			}
		}
		return length;
	}
}