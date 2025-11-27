package source_code;

import java.util.Scanner;

public class B_B3_10872_factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int result = fact(N);

		System.out.println(result);

		sc.close();
	}

	private static int fact(int n) {
		if (n == 0)
			return 1;

		return n * fact(n - 1);
	}
}
