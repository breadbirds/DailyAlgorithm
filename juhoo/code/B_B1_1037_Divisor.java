package source_code;

import java.io.*;
import java.util.*;

public class B_B1_1037_Divisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] divisor = new int[N];

		for (int i = 0; i < N; i++) {
			divisor[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(divisor);

		// 첫 수와 마지막 수 곱하기
		System.out.println(divisor[0] * divisor[N - 1]);
	}
}
