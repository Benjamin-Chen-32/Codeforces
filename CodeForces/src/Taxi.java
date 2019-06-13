import java.util.Scanner;

public class Taxi {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = in.nextInt();
		}
		int num4 = 0;
		int num3 = 0;
		int num2 = 0;
		int num1 = 0;
		for (int i = 0; i < N; i++) {
			int temp = input[i];
			if (temp == 1) {
				num1++;
			} else if (temp == 2) {
				num2++;
			} else if (temp == 3) {
				num3++;
			} else if (temp == 4) {
				num4++;
			}
		}
		int numCars = 0;
		numCars += num4;
		numCars += num3;
		if (num3 > num1) {
			num1 = 0;
		} else {
			num1 -= num3;
		}
		if (num2 % 2 == 0) {
			numCars += num2 / 2;
			num2 = 0;
		} else {
			num2 -= 1;
			numCars += num2 / 2;
			num2 = 1;
		}
		if (num2 == 1) {
			if (num1 >= 2) {
				num1 -= 2;
			} else {
				num1 = 0;
			}
			num2 = 0;
			numCars++;
		}
		if (num1 % 4 == 0) {
			numCars += num1 / 4;
		} else {
			numCars += num1 / 4;
			numCars++;
		}
		System.out.println(numCars);
		in.close();
	}
}