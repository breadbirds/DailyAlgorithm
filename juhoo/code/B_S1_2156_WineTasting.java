package source_code;

import java.io.*;
import java.util.*;

// 최대로 마시기
// 조건: 연속 3잔 안됨

public class B_S1_2156_WineTasting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] glasses = new int[n];

		for (int i = 0; i < n; i++) {
			glasses[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(glasses[0]);
			return;
		} else if (n == 2) {
			System.out.println(glasses[0] + glasses[1]);
			return;
		}

		int[] dp = new int[n];
		dp[0] = glasses[0];
		dp[1] = glasses[0] + glasses[1];
		dp[2] = Math.max(glasses[0] + glasses[1], Math.max(glasses[0], glasses[1]) + glasses[2]);

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(glasses[i - 1] + dp[i - 3], dp[i - 2]) + glasses[i]);
		}

		System.out.println(dp[n - 1]);
	}
}
