package utpc4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class CircusMayhem {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		LinkedList<Integer> flames = new LinkedList<Integer>();
		tk = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			flames.add(Integer.parseInt(tk.nextToken()));
		}
		int totalEnergy = 0;
		for (int i = 0; i < N - 1; i++) {
			int minEnergy = Integer.MAX_VALUE;
			ListIterator<Integer> it = flames.listIterator();
			int ind = 0;
			int toRemove = 0;
			while (it.hasNext()) {
				int currFlame = it.next();
				if (it.hasNext()) {
					int nextFlame = it.next();
					if (currFlame + nextFlame < minEnergy) {
						minEnergy = currFlame + nextFlame;
						toRemove = ind;
						it.set(currFlame + nextFlame);
					}
				}
				ind++;
			}
			flames.remove(toRemove);
			totalEnergy += minEnergy;
		}
		System.out.println(totalEnergy);
		in.close();
	}
}
