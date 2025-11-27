package source_code;

import java.io.*;

// 구해야 할 것: 가치의 최댓값

import java.util.*;

public class B_G5_12865_OrdinaryKnapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		int[][] stuff = new int[N][2]; // 각 물건의 무게와 해당 물건의 가치

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}

		// 배낭 무게를 기준으로 오름차순 정렬
		// 무게가 같다면 가치 내림차순
		Arrays.sort(stuff, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			} else {
				return Integer.compare(a[0], b[0]);
			}
		});

		// 값: 가치
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= stuff[i - 1][0]) {
					dp[i][j] = Math.max(dp[i - 1][j - stuff[i - 1][0]] + stuff[i - 1][1], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		// 최대 가치 찾기
		int max = 0;
		for (int i = 1; i < K + 1; i++) {
			if (max < dp[N][i]) {
				max = dp[N][i];
			}
			System.out.println(dp[N][i]);
		}

		System.out.println(max);
	}

}
