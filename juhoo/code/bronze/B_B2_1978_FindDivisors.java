package source_code;

import java.io.*;
import java.util.*;

public class B_B2_1978_FindDivisors {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isTrue = true;

			if (num == 1) {
				continue;
			}

			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					isTrue = false;
					break;
				}
			}

			if (isTrue == true) {
				result++;
			}
		}

		System.out.println(result);

	}

}
