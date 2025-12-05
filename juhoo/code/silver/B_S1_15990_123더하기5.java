package source_code;

import java.io.*;
import java.util.*;

// 같은 수 두 번 이상 연속 사용 안됨
// n을 1,2,3의 합으로 나타내는 방법의 수 구하기

public class B_S1_15990_123더하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		int maxN = 3;

		for (int tc = 0; tc < testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			if (n <= maxN) {
				System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
				continue;
			}

			for (int i = maxN + 1; i <= n; i++) {
				dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
				dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
				dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
			}

			System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
		}

	}

}
