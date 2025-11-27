package source_code;

import java.io.*;
import java.util.*;

public class B_S5_14916_Change {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine()); // 거스름돈 액수
		long change = 0;

		// 예외처리
		if (n < 2 || (n > 2 && n < 5)) {
			System.out.println(-1);
			return;
		}

		if ((n % 5) % 2 == 0) {
			change += n / 5;
			n %= 5;
			change += n / 2;
		} else {
			change += n / 5 - 1;
			n = (n % 5) + 5;
			change += n / 2;
		}

		System.out.println(change);

	}

}
