package kickstart2021f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Festival {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int D = Integer.parseInt(tk.nextToken());
			int N = Integer.parseInt(tk.nextToken());
			int K = Integer.parseInt(tk.nextToken());
			LinkedList<Interval>[] intervals = new LinkedList[D];
			for (int i = 0; i < D; i++) {
				intervals[i] = new LinkedList<Interval>();
			}
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(in.readLine());
				int happiness = Integer.parseInt(tk.nextToken());
				int start = Integer.parseInt(tk.nextToken()) - 1;
				int end = Integer.parseInt(tk.nextToken()) - 1;
				intervals[start].add(new Interval(true, happiness));
				intervals[end].add(new Interval(false, happiness));
			}
			int maxHappiness = 0;
			PriorityQueue<Integer> happinesses = new PriorityQueue<Integer>(Collections.reverseOrder());
			for (int i = 0; i < D; i++) {
				int happiness = 0;
				for (Interval interval : intervals[i]) {
					if (interval.start) {
						happinesses.add(interval.happiness);
					}
				}
				LinkedList<Integer> toReadd = new LinkedList<Integer>();
				for (int j = 0; j < K; j++) {
					if (happinesses.isEmpty()) {
						break;
					}
					int toAdd = happinesses.poll();
					happiness += toAdd;
					toReadd.add(toAdd);
				}
				happinesses.addAll(toReadd);
				for (Interval interval : intervals[i]) {
					if (!interval.start) {
						happinesses.remove(interval.happiness);
					}
				}
				maxHappiness = Math.max(maxHappiness, happiness);
			}
			System.out.print("Case #" + (t + 1) + ": " + maxHappiness);
			if (t != T - 1) {
				System.out.print("\n");
			}
		}
		in.close();
	}

	static class Interval {
		boolean start;
		int happiness;

		public Interval(boolean start, int happiness) {
			this.start = start;
			this.happiness = happiness;
		}
	}
}