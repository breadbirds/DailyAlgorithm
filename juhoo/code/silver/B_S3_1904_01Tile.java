package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1904_01Tile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 자릿수

		if (N == 1) {
			System.out.println(1);
			return;
		} else if (N == 2) {
			System.out.println(2);
			return;
		}

		// DP
		// 마지막 수 0: n-2의 개수
		// 마지막 수 1: N-1의 개수
		int[] dp = new int[N];
		dp[0] = 1; // {1}
		dp[1] = 2; // {00, 11}

		for (int i = 2; i < N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}

		System.out.println(dp[N - 1]);
	}

}
