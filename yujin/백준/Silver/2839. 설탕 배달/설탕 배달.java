import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
//		int arr[] = new int[1000];
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < 1667; i++) {
			for (int j = 0; j <= 1000; j++) {
				if (((3 * i) + (5 * j)) == N) {
					int sum = i + j;
					if (sum < minSum) {
						minSum = sum;
					}

				}

			}
		}
		if (minSum == Integer.MAX_VALUE) {
			System.out.print("-1");

		} else {
			System.out.print(minSum);
		}

	}
}