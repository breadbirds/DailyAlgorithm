package source_code;

import java.io.*;
import java.util.*;

public class B_S3_9461_PadovanSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] input = new int[T];
		int maxInput = 0;

		for (int i = 0; i < T; i++) {
			input[i] = Integer.parseInt(br.readLine());

			maxInput = Math.max(maxInput, input[i]);
		}

		if (maxInput < 6) {
			for (int i = 0; i < T; i++) {
				if (input[i] <= 3) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			}
		}

		// maxInput까지 수열 구하기
		long[] sequence = new long[maxInput + 1];
		sequence[1] = 1;
		sequence[2] = 1;
		sequence[3] = 1;
		sequence[4] = 2;
		sequence[5] = 2;

		for (int i = 6; i <= maxInput; i++) {
			sequence[i] = sequence[i - 1] + sequence[i - 5];
		}

		// 정답 출력
		for (int i = 0; i < T; i++) {
			System.out.println(sequence[input[i]]);
		}
	}

}
