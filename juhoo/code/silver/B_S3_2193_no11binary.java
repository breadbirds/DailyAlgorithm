package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2193_no11binary {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(1);
			return;
		} else if (N == 2) {
			System.out.println(1);
			return;
		}

		long[] dp = new long[N];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[N - 1]);
	}

}
