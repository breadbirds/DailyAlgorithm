package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1072_Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long Z = Y * 100 / X;

		// 추가로 이긴 게임 횟수 탐색
		long min = 1;
		long max = 1000000000;
		long newZ = 0;
		long mid = 0;
		long ans = -1;

		while (min <= max) {
			mid = (max + min) / 2;
			newZ = (Y + mid) * 100 / (X + mid);

			if (newZ == Z) {
				min = mid + 1;
			} else if (newZ >= Z + 1) {
				max = mid - 1;
				ans = mid;
			}
		}

		System.out.println(ans);
	}

}
