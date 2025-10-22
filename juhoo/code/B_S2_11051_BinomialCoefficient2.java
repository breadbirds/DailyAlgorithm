package source_code;

import java.io.*;
import java.util.*;

public class B_S2_11051_BinomialCoefficient2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// �Ľ�Į�� �ﰢ�� ��ȭ�� ���
		long[][] dp = new long[N + 1][K + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			// �⺻ ����
			dp[i][0] = 1;

			// ��ȭ��
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
			}
		}

		System.out.println(dp[N][K]);
	}

}
