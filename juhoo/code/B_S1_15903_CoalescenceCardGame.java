package source_code;

import java.io.*;
import java.util.*;

public class B_S1_15903_CoalescenceCardGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] cardArray = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cardArray[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			Arrays.sort(cardArray);

			// 가장 작은 두 수를 pick
			long num1 = cardArray[0];
			long num2 = cardArray[1];

			long sum = num1 + num2;

			cardArray[0] = sum;
			cardArray[1] = sum;
		}

		// 결과 계산
		long resultSum = 0;

		for (long n : cardArray) {
			resultSum += n;
		}

		System.out.println(resultSum);
	}

}
