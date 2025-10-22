package source_code;

import java.io.*;
import java.util.*;

public class B_S2_11051_BinomialCoefficient2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 파스칼의 삼각형 점화식 사용
		long[][] dp = new long[N + 1][K + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			// 기본 조건
			dp[i][0] = 1;

			// 점화식
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
			}
		}

		System.out.println(dp[N][K]);
	}

}
