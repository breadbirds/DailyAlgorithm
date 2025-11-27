package source_code;

import java.io.*;
import java.util.*;

public class B_S5_13301_tileDecoration {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long prev1 = 1;
		long prev2 = 1;

		if (N == 1) {
			System.out.println(4);
			return;
		} else if (N == 2) {
			System.out.println(6);
			return;
		}

		long[] dp = new long[N];
		dp[0] = 4;
		dp[1] = 6;

		for (int i = 2; i < N; i++) {
			dp[i] = dp[i - 1] + (prev1 + prev2) * 2;

			long temp = prev2;
			prev2 = prev1;
			prev1 = prev1 + temp;
		}

		System.out.println(dp[N - 1]);
	}
}
