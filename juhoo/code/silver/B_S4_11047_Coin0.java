package source_code;

import java.io.*;
import java.util.*;

public class B_S4_11047_Coin0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전 종류
		long K = Integer.parseInt(st.nextToken()); // 가치 합
		long[] value = new long[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			value[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(value);

		for (int i = value.length - 1; i >= 0; i--) {
			if (value[i] <= K && K > 0) {
				long repetitionCnt = K / value[i];

				cnt += repetitionCnt;
				K -= value[i] * repetitionCnt;
			}
		}

		System.out.println(cnt);
	}

}
