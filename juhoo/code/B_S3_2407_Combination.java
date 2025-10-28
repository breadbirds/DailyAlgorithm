package source_code;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B_S3_2407_Combination {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (n < 3) {
			System.out.println(1);
			return;
		}

		BigInteger[][] dp = new BigInteger[n + 2][n + 2];
		// ÃÊ±âÈ­
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = BigInteger.ONE;
			}
		}

		for (int i = 3; i <= n + 1; i++) {
			for (int j = 2; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
			}
		}

		System.out.println(dp[n + 1][m + 1]);
	}

}
