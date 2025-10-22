package source_code;

import java.io.*;
import java.util.*;

public class B_S5_1010_buildBridge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int westCnt = Integer.parseInt(st.nextToken());
			int eastCnt = Integer.parseInt(st.nextToken());

			// 조합 계산
			int[] dp = new int[eastCnt + 1];
			dp[0] = 1;

			for (int i = 1; i <= eastCnt; i++) {
				for (int j = i; j >= 1; j--) {
					dp[j] = dp[j] + dp[j - 1];
				}
			}

			sb.append(dp[westCnt]).append("\n");
		}

		System.out.println(sb);
	}

}
