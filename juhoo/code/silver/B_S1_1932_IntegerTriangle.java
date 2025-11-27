package source_code;

import java.io.*;
import java.util.*;

// 구하는 것: 합의 최댓값
// 방향: 좌우 대각선 아래

public class B_S1_1932_IntegerTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 예외 처리
		if (N == 1) {
			System.out.println(input[0][0]);
			return;
		} else if (N == 2) {
			System.out.println(Math.max(input[0][0] + input[1][0], input[0][0] + input[1][1]));
			return;
		}

		// DP
		int[][] dp = new int[N + 1][N + 1];
		dp[0][0] = input[0][0];
		dp[1][0] = dp[0][0] + input[1][0];
		dp[1][1] = dp[0][0] + input[1][1];

		for (int i = 2; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + input[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + input[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + input[i][j];
				}
			}
		}

		// 최댓값 찾기
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[N - 1][i]);
		}

		System.out.println(max);
	}

}
