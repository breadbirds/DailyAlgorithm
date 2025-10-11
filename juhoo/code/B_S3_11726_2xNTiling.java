package source_code;

import java.io.*;
import java.util.*;

public class B_S3_11726_2xNTiling {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1 || N == 2) {
			System.out.println(N);
		} else {
			long[] dp = new long[N + 1];
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}

			System.out.println(dp[N]);
		}

	}
}
