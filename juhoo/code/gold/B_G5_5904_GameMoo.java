package source_code;

import java.io.*;
import java.util.*;

// S(k) = S(K-1) + 'm' + 'o'*(k+2)개 + S(K-1)

public class B_G5_5904_GameMoo {
	static char result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N번째 글자 구하기

		if (N == 1) {
			System.out.println('m');
			return;
		} else if (N == 2 || N == 3) {
			System.out.println('o');
			return;
		}

		// k찾기
		List<Integer> length = new ArrayList<>();

		int k = 0;
		length.add(3);
		while (length.get(length.size() - 1) < N) {
			k++;
			length.add(length.get(length.size() - 1) * 2 + k + 3);
		}

		DevideAndConquer(N, length, k);

		System.out.println(result);

	}

	private static void DevideAndConquer(int n, List<Integer> length, int k) {
		if (k == 0) {
			if (n == 1) {
				result = 'm';
			} else {
				result = 'o';
			}
			return;
		}

		if (n <= length.get(k - 1)) {
			DevideAndConquer(n, length, k - 1);
		} else if (n == length.get(k - 1) + 1) {
			result = 'm';
		} else if (n > length.get(k - 1) && n <= length.get(k - 1) + k + 3) {
			result = 'o';
		} else {
			DevideAndConquer(n - length.get(k - 1) - k - 3, length, k - 1);
		}
	}

}
