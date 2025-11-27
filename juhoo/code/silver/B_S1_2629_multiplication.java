package source_code;

import java.io.*;
import java.util.*;

// 분할 정복 - 거듭제곱

public class B_S1_2629_multiplication {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long result = DevideAndConquer(A, B, C);
		System.out.println(result);
	}

	private static long DevideAndConquer(long a, long b, long c) {
		long result = 0;

		if (b < 1) {
			return 1;
		}

		if (b % 2 == 0) {
			result = (long) powDouble((DevideAndConquer(a % c, b / 2, c)), c) % c;
		} else {
			result = (long) powDouble((DevideAndConquer(a % c, b / 2, c)), c) * a % c;
		}

		return result;
	}

	// 제곱하는 함수 (Math.pow가 long 처리를 못함)
	private static long powDouble(long num, long c) {
		return num * num % c;
	}
}
