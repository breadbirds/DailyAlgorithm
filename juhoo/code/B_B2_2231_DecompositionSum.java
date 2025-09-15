package source_code;

import java.io.*;
import java.util.*;

public class B_B2_2231_DecompositionSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		int num = N / 2;
		while (num < N) {
			int sum = num;
			int num2 = num;

			for (int i = String.valueOf(num).length() - 1; i >= 0; i--) {
				int digit = num2 / (int) Math.pow(10, i);
				num2 -= (int) Math.pow(10, i) * digit;
				sum += digit;
			}

			if (sum == N) {
				result = num;
				break;
			}
			num++;
		}

		System.out.println(result);

	}

}
