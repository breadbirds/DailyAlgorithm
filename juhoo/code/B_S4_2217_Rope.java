package source_code;

import java.io.*;
import java.util.*;

public class B_S4_2217_Rope {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		// Á¤·Ä
		Arrays.sort(rope);

		int max = 0;

		for (int i = 0; i < N; i++) {
			int cal = 0;
			int ropeCnt = N - i;
			cal = ropeCnt * rope[i];
			max = Math.max(cal, max);
		}

		System.out.println(max);
	}

}
