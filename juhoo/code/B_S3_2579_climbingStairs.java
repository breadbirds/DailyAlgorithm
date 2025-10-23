package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2579_climbingStairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] stairsRank = new int[N];

		for (int i = 0; i < N; i++) {
			stairsRank[i] = Integer.parseInt(br.readLine());
		}

		// DP
		int[] dp = new int[N + 1];
		dp[1] = stairsRank[0];
		if (N >= 2) {
			dp[2] = stairsRank[1] + dp[1];
		}
		if (N >= 3) {
			dp[3] = Math.max(stairsRank[0], stairsRank[1]) + stairsRank[2];
		}

		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], stairsRank[i - 2] + dp[i - 3]) + stairsRank[i - 1];
		}

		System.out.println(dp[N]);
	}

}
