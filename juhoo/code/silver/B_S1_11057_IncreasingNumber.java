package source_code;

import java.io.*;
import java.util.*;

public class B_S1_11057_IncreasingNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수의 길이

		// DP
		int[][] dp = new int[N + 1][10]; // {자릿수, 끝 자리 숫자}
		for (int i = 0; i < 10; i++) {
			dp[1][i] = i + 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
				}
			}
		}

		System.out.println(dp[N][9]);
	}

}
