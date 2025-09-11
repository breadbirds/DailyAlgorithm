package source_code;

import java.io.*;
import java.util.*;

public class B_S1_5525_IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String input = br.readLine();

		// 비교
		int cnt = 0;
		int idx = 0;
		int streak = 0; // 연속 개수

		while (idx < M - 2) {
			if (input.substring(idx, idx + 3).equals("IOI")) {
				streak++;
				idx += 2;

				if (streak == N) {
					cnt++;
					streak--;
				}
			} else {
				idx++;
				streak = 0;
			}
		}

		System.out.println(cnt);
	}

}
