package source_code;

import java.io.*;
import java.util.*;

// 연속해서 같은 색이 올 수 없음
// 구하는 것: 비용의 최솟값

public class B_S1_1149_RGB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 집의 수
		int[][] cost = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][j];
				} else if (j == 1) {
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][j];
				}
			}
		}

		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
	}

}
