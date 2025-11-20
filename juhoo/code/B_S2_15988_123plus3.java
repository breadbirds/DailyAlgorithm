package source_code;

import java.io.*;
import java.util.*;

// 조건: 1개 이상 사용 / 123의 합으로 구성
// 구하는 것: 방법의 수

public class B_S2_15988_123plus3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		int[] numbers = new int[T];

		for (int i = 0; i < T; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}

		long[] dp = new long[max + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		int curIdx = 4;

		for (int tc = 0; tc < T; tc++) {
			int n = numbers[tc];
			if (n < curIdx) {
				System.out.println(dp[n]);
				continue;
			}

			for (int i = curIdx; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
			}

			curIdx++;
			System.out.println(dp[n]);
		}
	}

}
