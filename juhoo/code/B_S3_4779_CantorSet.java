package source_code;

import java.io.*;
import java.util.*;

public class B_S3_4779_CantorSet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			int strLength = (int) Math.pow(3, N);
			char[] start = new char[strLength];

			if (N == 0) {
				System.out.println("-");
				continue;
			}

			for (int i = 0; i < strLength; i++) {
				start[i] = '-';
			}

			DevideAndConquer(start);

			StringBuilder result = new StringBuilder();
			for (int i = 0; i < start.length; i++) {
				result.append(start[i]);
			}
			System.out.println(result);
		}
	}

	private static void DevideAndConquer(char[] start) {
		int length = start.length;

		if (length < 2) {
			return;
		}

		// left
		char[] left = Arrays.copyOfRange(start, 0, length / 3);
		DevideAndConquer(left);
		System.arraycopy(left, 0, start, 0, left.length);

		// middle
		for (int i = length / 3; i < length / 3 * 2; i++) {
			start[i] = ' ';
		}

		// right
		char[] right = Arrays.copyOfRange(start, 0, length / 3);
		DevideAndConquer(right);
		System.arraycopy(right, 0, start, length / 3 * 2, right.length);
	}

}
