package source_code;

import java.io.*;
import java.util.*;

// 구해야 하는 것: 사탕 개수 최댓값

public class B_S2_11048_Move {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] miro = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N + 1][M + 1];
		int[] dx = { 1, 0, 1 };
		int[] dy = { 0, 1, 1 };

		dp[1][1] = miro[1][1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int d = 0; d < 3; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];

					if (ny > 0 && nx > 0 && ny <= N && nx <= M) {
						dp[ny][nx] = Math.max(dp[ny][nx], dp[i][j] + miro[ny][nx]);
					}
				}
			}
		}

		System.out.println(dp[N][M]);
	}

}
