package utpc1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutePets {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		PetOwner[] owners = new PetOwner[N];
		PetCute[] cutes = new PetCute[N];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine());
			int numOwners = Integer.parseInt(tk.nextToken());
			int numCutes = Integer.parseInt(tk.nextToken());
			PetOwner owner = new PetOwner(i, numOwners, numCutes);
			PetCute cute = new PetCute(i, numOwners, numCutes);
			owners[i] = owner;;
			cutes[i] = cute;
		}
		in.close();
		Arrays.sort(owners);
		Arrays.sort(cutes);
		for (int i = 0; i < N; i++) {
			if (owners[i].type != cutes[i].type) {
				System.out.println("yes");
				return;
			}
		}
		System.out.println("no");
	}

	static class PetOwner implements Comparable<PetOwner>{
		int type = 0;
		int owners = 0;
		int cutes = 0;

		public PetOwner(int type, int owners, int cutes) {
			this.type = type;
			this.owners = owners;
			this.cutes = cutes;
		}

		@Override
		public int compareTo(PetOwner o) {
			if (this.owners == o.owners) {
				return Integer.compare(this.cutes, o.cutes);
			}
			return Integer.compare(this.owners, o.owners);
		}
	}

	static class PetCute implements Comparable<PetCute> {
		int type = 0;
		int owners = 0;
		int cutes = 0;

		public PetCute(int type, int owners, int cutes) {
			this.type = type;
			this.owners = owners;
			this.cutes = cutes;
		}

		@Override
		public int compareTo(PetCute o) {
			if (this.cutes == o.cutes) {
				return Integer.compare(this.owners, o.owners);
			}
			return Integer.compare(this.cutes, o.cutes);
		}
	}
}