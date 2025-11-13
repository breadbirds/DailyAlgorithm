package source_code;

import java.io.*;
import java.util.*;

// 2차원 상하좌우 탐색 + 4방향으로 이어지면 안됨
// 가중치: 점수
// 점수가 최대가 되게 구하기
// DP

public class B_S1_9465_Sticker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			int n = Integer.parseInt(br.readLine()); // 열의 개수
			int[][] sticker = new int[2][n];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// DP
			// {x, y}
			int[][] dp = new int[2][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];

			for (int x = 1; x < n; x++) {
				int lastUp = dp[0][x - 1] + sticker[1][x]; // 이전 열에서 위를 골랐다는 가정
				int lastDown = dp[1][x - 1] + sticker[0][x]; // 이전 열에서 아래를 골랐다는 가정
				int lastNothing0 = 0; // 이전 열에서 아무것도 고르지 않음
				int lastNothing1 = 0;
				
				if (x != 1) {
					lastNothing0 = Math.max(dp[0][x - 2], dp[1][x - 2]) + sticker[0][x];
					lastNothing1 = Math.max(dp[0][x - 2], dp[1][x - 2]) + sticker[1][x];
				}

				dp[0][x] = Math.max(lastDown, lastNothing0);
				dp[1][x] = Math.max(lastUp, lastNothing1);
			}

			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));

		}
	}

}
