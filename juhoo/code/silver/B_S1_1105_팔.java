package source_code;

import java.io.*;
import java.util.*;

public class B_S1_1105_팔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long L = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		long result = 0;

		// 같은 자릿수인지 확인
		String l = String.valueOf(L);
		String r = String.valueOf(R);

		if (l.length() == r.length()) {
			// 같은 수인지 확인
			if (L == R) {
				result = calEightCnt(L);
			} else {
				// 몇번째 인덱스까지 동일한지 찾기
				int idx = -1;
				for (int i = 0; i < l.length(); i++) {
					if (l.charAt(i) == r.charAt(i)) {
						idx = i;
					} else {
						break;
					}
				}

				if (idx == -1) {
					System.out.println(0);
					return;
				} else {
					result = calEightCnt(Long.parseLong(l.substring(0, idx + 1)));
				}
			}
			System.out.println(result);
		} else {
			System.out.println(0);
		}

	}

	private static long calEightCnt(long n) {
		int result = 0;
		String str = String.valueOf(n);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '8') {
				result++;
			}
		}

		return result;
	}
}
