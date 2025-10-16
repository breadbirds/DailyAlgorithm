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

		// ������ �ð��� ���� ������� ����
		Arrays.sort(input, (a, b) -> {
			if (a[1] != b[1]) {
				return Integer.compare(a[1], b[1]);
			} else {
				return Integer.compare(a[0], b[0]);
			}
		});

		int curtime = 0;

		for (int i = 0; i < N; i++) {
			// ������ �ð��� ª���� �켱������ ī��Ʈ
			if (curtime <= input[i][0]) {
				result++;
				curtime = input[i][1];
			}
		}

		System.out.println(result);

	}
}
