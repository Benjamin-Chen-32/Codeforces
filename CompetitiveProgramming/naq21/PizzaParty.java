import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class PizzaParty {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		@SuppressWarnings("unchecked")
		LinkedList<String>[] queries = new LinkedList[c];
		HashSet<String> toppings = new HashSet<String>();
		for (int i = 0; i < c; i++) {
			queries[i] = new LinkedList<String>();
			Collections.addAll(queries[i], in.readLine().split(" "));
			if (queries[i].size() == 1) {
				toppings.add(queries[i].peek());
			} else {
				queries[i].poll();
			}
		}
		boolean[] used = new boolean[c];
		for (int pass = 0; pass < c; pass++) {
			for (int i = 0; i < c; i++) {
				LinkedList<String> query = queries[i];
				int size = query.size();
				if (size > 1 && !used[i]) {
					if (query.get(1).equals("or")) {
						int ind = 0;
						String toAdd = query.getLast();
						for (String topping : query) {
							if (ind < size - 2 && !topping.equals("or")) {
								if (toppings.contains(topping)) {
									toppings.add(toAdd);
									used[i] = true;
									break;
								}
							}
							ind++;
						}
					} else {
						int ind = 0;
						String toAdd = query.getLast();
						boolean found = true;
						for (String topping : query) {
							if (ind < size - 2 && !topping.equals("and")) {
								if (!toppings.contains(topping)) {
									found = false;
									break;
								}
							}
							ind++;
						}
						if (found) {
							toppings.add(toAdd);
							used[i] = true;
						}
					}
				}
			}
		}
		System.out.println(toppings.size());
		in.close();
	}
}
