package source_code;

import java.io.*;
import java.util.*;

public class B_B2_2581_PromeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		boolean isFirst = false;

		for (int i = N; i < M; i++) {
			boolean isTrue = true;

			if (i == 1) {
				continue;
			}

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isTrue = false;
					break;
				}
			}

			if (isTrue == true) {
				if (isFirst == false) {
					min = i;
					isFirst = true;
				}

				sum += i;

			}
		}

		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
