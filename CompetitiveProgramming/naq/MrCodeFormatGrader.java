import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MrCodeFormatGrader {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int c = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine());
		boolean[] lines = new boolean[c];
		for (int i = 0; i < n; i++) {
			int line = Integer.parseInt(tk.nextToken()) - 1;
			lines[line] = true;
		}
		boolean curr = lines[0];
		int start = 0;
		LinkedList<Interval> correct = new LinkedList<Interval>();
		LinkedList<Interval> error = new LinkedList<Interval>();
		for (int i = 0; i < c; i++) {
			if (lines[i] != curr) {
				if (curr) {
					error.add(new Interval(start + 1, i));
				} else {
					correct.add(new Interval(start + 1, i));
				}
				start = i;
				curr = lines[i];
			}
		}
		if (curr) {
			error.add(new Interval(start + 1, c));
		} else {
			correct.add(new Interval(start + 1, c));
		}
		System.out.print("Errors: ");
		int numErrors = error.size();
		int numCorrect = correct.size();
		int i = 0;
		for (Interval interval : error) {
			if (interval.start == interval.end) {
				System.out.print(interval.start);
			} else {
				System.out.print(interval.start + "-" + interval.end);
			}
			if (i == numErrors - 2 && numErrors > 1) {
				System.out.print(" and ");
			} else if (i < numErrors - 1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println();
		i = 0;
		System.out.print("Correct: ");
		for (Interval interval : correct) {
			if (interval.start == interval.end) {
				System.out.print(interval.start);
			} else {
				System.out.print(interval.start + "-" + interval.end);
			}
			if (i == numCorrect - 2 && numCorrect > 1) {
				System.out.print(" and ");
			} else if (i < numCorrect - 1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println();
		in.close();
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
