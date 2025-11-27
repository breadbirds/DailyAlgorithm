package source_code;

import java.io.*;
import java.util.*;

public class B_B3_2720_LaundromatOwnerDonghyuk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케 개수
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			int q = 0, d = 0, n = 0, p = 0;
			int cal = Integer.parseInt(br.readLine());

			q = cal / 25;
			cal -= q * 25;

			d = cal / 10;
			cal -= d * 10;

			n = cal / 5;
			cal -= n * 5;
			
			p = cal;

			sb.append(q + " " + d + " " + n + " " + p + "\n");
		}

		System.out.println(sb);
	}
}
