package source_code;

import java.io.*;
import java.util.*;

public class B_B3_1929_FindPrimeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long M = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (long n = M; n <= N; n++) {
			boolean isPrime = true;

			if (n == 1) {
				isPrime = false;
			} else if (n == 2) {
				isPrime = true;
			} else {
				for (long i = 2; i * i <= n; i++) {
					if (n % i == 0) {
						isPrime = false;
						break;
					}
				}
			}

			if (isPrime) {
				sb.append(n);

				if (n != N) {
					sb.append("\n");
				}
			}
		}

		System.out.println(sb);
	}

}
