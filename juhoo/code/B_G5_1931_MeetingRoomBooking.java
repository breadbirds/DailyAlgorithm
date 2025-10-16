package source_code;

import java.io.*;
import java.util.*;

public class B_G5_1931_MeetingRoomBooking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2];
		int result = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		// 끝나는 시간이 빠른 순서대로 정렬
		Arrays.sort(input, (a, b) -> {
			if (a[1] != b[1]) {
				return Integer.compare(a[1], b[1]);
			} else {
				return Integer.compare(a[0], b[0]);
			}
		});

		int curtime = 0;

		for (int i = 0; i < N; i++) {
			// 끝나는 시간이 짧은걸 우선적으로 카운트
			if (curtime <= input[i][0]) {
				result++;
				curtime = input[i][1];
			}
		}

		System.out.println(result);

	}
}
