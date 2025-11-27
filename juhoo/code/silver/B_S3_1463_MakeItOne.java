package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1463_MakeItOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			} else {
				dp[i] = dp[i - 1] + 1;
			}

		}

		System.out.println(dp[N]);

	}

}
