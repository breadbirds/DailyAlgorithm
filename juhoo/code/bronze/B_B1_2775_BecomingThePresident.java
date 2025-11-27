package source_code;

import java.io.*;
import java.util.*;

public class B_B1_2775_BecomingThePresident {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 0; testCase < tc; testCase++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			int[][] dp = new int[k][n + 1];

			// 0층 초기값 설정
			for (int i = 1; i <= n; i++) {
				dp[0][i] = i;
			}

			// 점화식 적용
			for (int y = 1; y < k; y++) {
				for (int x = 1; x <= n; x++) {
					int sum = 0;

					for (int j = 1; j <= x; j++) {
						sum += dp[y - 1][j];
					}

					dp[y][x] = sum;
				}
			}

			// 전 층의 거주민 수 합 구하기
			int result = 0;
			for (int i = 1; i < n + 1; i++) {
				result += dp[k - 1][i];
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

}
