package source_code;

import java.io.*;
import java.util.*;

public class B_G5_3079_Immigration {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 심사대 개수
		int M = Integer.parseInt(st.nextToken()); // 사람 수
		int[] time = new int[N]; // 심사대별 심사 시간

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(time);

		long lo = 1; // 개별 최저 시간
		long hi = (long) time[0] * M; // 개별 최대 시간
		long ans = 0; // 총 걸린 시간

		while (lo <= hi) {
			long mid = (lo + hi) / 2;

			// mid 시간동안 심사 가능한 사람 수 계산
			long cal = 0L;
			for (int i = 0; i < N; i++) {
				if (cal > M) {
					break;
				}

				cal += mid / time[i]; // mid 시간만큼 각 심사대에서 심사를 동시에 하면서 시간 체크
			}

			if (cal >= M) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(ans);
	}

}
