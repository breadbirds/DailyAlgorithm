package source_code;

import java.io.*;
import java.util.*;

public class B_S3_19637_WriteIfForMe {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 칭호 개수
		int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수
		String[] str = new String[N];
		int[] power = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}

		int[] numbers = new int[M];
		for (int i = 0; i < M; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		for (int num : numbers) {
			int lo = 0, hi = N - 1;
			String ans = "ERROR";

			while (lo <= hi) {
				int mid = (lo + hi) / 2;

				if (num <= power[mid]) {
					ans = str[mid];
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			}
			
			System.out.println(ans);
		}

	}

}
