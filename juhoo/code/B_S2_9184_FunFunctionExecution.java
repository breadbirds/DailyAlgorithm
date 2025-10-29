package source_code;

import java.io.*;
import java.util.*;

public class B_S2_9184_FunFunctionExecution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 21, b = 21, c = 21;

		int[][][] dp = new int[a][b][c];

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int k = 0; k < c; k++) {
					if (i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 1;
						continue;
					} else if (i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					} else {
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			int result = 0;

			if (a <= 0 || b <= 0 || c <= 0) { // 음수 인덱스 예외 처리
				result = 1;
			} else if (a > 20 || b > 20 || c > 20) {
				result = dp[20][20][20];
			} else {
				result = dp[a][b][c];
			}

			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
		}
	}

}
