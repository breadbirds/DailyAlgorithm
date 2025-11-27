package source_code;

import java.io.*;
import java.util.*;

// а╤гу
public class B_B1_11050_BinomialCoefficient {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(com(N, K));
	}

	private static int com(int n, int k) {
		int result = fact(n) / fact(k);
		result /= fact(n - k);

		return result;

	}

	private static int fact(int n) {
		if (n <= 1) {
			return 1;
		}

		return n * fact(n - 1);
	}
}
