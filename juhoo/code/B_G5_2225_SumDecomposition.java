package source_code;

import java.io.*;
import java.util.StringTokenizer;

//0 ~ N까지 정수를 K개 더해서 그 합이 N이 되는 경우의 수

public class B_G5_2225_SumDecomposition {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// {총합, 더하는 개수}
		long[][] dp = new long[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				for (int k = 0; k <= i; k++) { // 마지막 자리가 1~N까지인 경우의 수
					dp[i][j] += (dp[i - k][j - 1]) % 1000000000;
				}
			}
		}

		System.out.println(dp[N][K] % 1000000000);
	}
}
