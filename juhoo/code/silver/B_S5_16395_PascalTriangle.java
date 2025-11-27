package source_code;

import java.io.*;
import java.util.*;

public class B_S5_16395_PascalTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n < 2 || k < 2) {
			System.out.println(1);
			return;
		}

		long[][] dp = new long[n + 1][k + 1];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j == 1 || j == n) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
