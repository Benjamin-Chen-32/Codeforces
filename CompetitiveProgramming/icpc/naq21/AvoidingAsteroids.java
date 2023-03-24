import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvoidingAsteroids {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		double[][] ship = new double[2][3];
		for (int i = 0; i < 3; i++) {
			ship[0][i] = Double.parseDouble(tk.nextToken());
		}
		double[] base = new double[3];
		for (int i = 0; i < 3; i++) {
			base[i] = Double.parseDouble(tk.nextToken());
		}
		for (int i = 0; i < 3; i++) {
			ship[1][i] = base[i] - ship[0][i];
		}
		double magA = mag(ship[1]);
		ship[1] = normalize(ship[1]);
		int n = Integer.parseInt(tk.nextToken());
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine());
			Asteroid curr = new Asteroid();
			for (int j = 0; j < 3; j++) {
				curr.p[j] = Double.parseDouble(tk.nextToken());
			}
			for (int j = 0; j < 3; j++) {
				curr.d[j] = Double.parseDouble(tk.nextToken());
			}
			int m = Integer.parseInt(tk.nextToken());
			tk = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				double r = 0;
				double[] coords = new double[3];
				for (int k = 0; k < 3; k++) {
					coords[k] = Double.parseDouble(tk.nextToken());
				}
				r = mag(coords, curr.p);
				curr.r = Math.max(curr.r, r);
			}
			double[] cross = crossProd(ship[1], curr.d);
			double denom = mag(cross);
			denom *= denom;
			double dist = 0;
			if (denom == 0) {
				double[] pointDiff = new double[3];
				for (int j = 0; j < 3; j++) {
					pointDiff[j] = curr.p[j] - ship[0][j];
				}
				double d0 = dotProd(ship[1], pointDiff);
				double[] otherDiff = new double[3];
				for (int j = 0; j < 3; j++) {
					otherDiff[j] = curr.d[j] - ship[0][j];
				}
				double d1 = dotProd(ship[1], otherDiff);
				if (d0 <= 0 && d1 <= 0) {
					if (Math.abs(d0) < Math.abs(d1)) {
						dist = mag(ship[0], curr.p);
					} else {
						dist = mag(ship[0], curr.d);
					}
				} else if (d0 >= magA && d1 >= magA) {
					if (Math.abs(d0) < Math.abs(d1)) {
						dist = mag(ship[1], curr.p);
					} else {
						dist = mag(ship[1], curr.d);
					}
				} else {
					double[] mult = new double[3];
					for (int j = 0; j < 3; j++) {
						mult[j] = d0 * ship[1][j];
						mult[j] += ship[0][j];
						mult[j] -= curr.p[j];
					}
					dist = mag(mult);
				}
			} else {
				double[] diff = new double[3];
				for (int j = 0; j < 3; j++) {
					diff[j] = ship[1][j] - curr.d[j];
				}
				dist = dotProd(diff, cross) / denom;
			}
			if (dist < 0.000001) {
				System.out.println("Surrender");
				in.close();
				return;
			}
		}
		System.out.println("Go");
		in.close();
	}

	static double mag(double[] a, double[] b) {
		double dist = 0;
		for (int i = 0; i < 3; i++) {
			dist += (a[i] - b[i]) * (a[i] - b[i]);
		}
		return Math.sqrt(dist);
	}

	static double mag(double[] a) {
		double dist = 0;
		for (int i = 0; i < 3; i++) {
			dist += a[i] * a[i];
		}
		return Math.sqrt(dist);
	}

	static double[] normalize(double[] a) {
		double mag = mag(a);
		for (int i = 0; i < 3; i++) {
			a[i] /= mag;
		}
		return a;
	}

	static double dotProd(double[] a, double[] b) {
		double prod = 0;
		for (int i = 0; i < 3; i++) {
			prod += a[i] * b[i];
		}
		return prod;
	}

	static double[] crossProd(double[] a, double[] b) {
		double[] cross = new double[3];
		cross[0] = a[1] * b[2] - a[2] * b[1];
		cross[1] = a[2] * b[0] - a[0] * b[2];
		cross[2] = a[0] * b[1] - a[1] * b[0];
		return cross;
	}

	static class Asteroid {
		double[] p;
		double[] d;
		double r;

		public Asteroid() {
			this.p = new double[3];
			this.d = new double[3];
		}

		public Asteroid(double[] p, double[] d, double r) {
			this.p = p;
			this.d = d;
			this.r = r;
		}
	}
}
