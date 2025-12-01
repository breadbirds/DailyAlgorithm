package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1448_삼각형만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] lines = new int[N];

		for (int i = 0; i < N; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lines);

		// 3개 이하일때는 바로 처리
		if (N == 3) {
			if (lines[2] < lines[0] + lines[1]) {
				System.out.println(lines[0] + lines[1] + lines[2]);
			} else {
				System.out.println(-1);
			}
			return;
		}

		for (int i = N - 1; i >= 2; i--) {
			int a = lines[i];
			int b = lines[i - 1];
			int c = lines[i - 2];

			boolean canMake = (a < b + c) ? true : false;

			if (canMake == true) {
				System.out.println(a + b + c);
				break;
			} else if (i == 2) {
				System.out.println(-1);
			}
		}
	}

}
