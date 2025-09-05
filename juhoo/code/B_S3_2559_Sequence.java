package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2559_Sequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] inputArray = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}

		int maxSum = Integer.MIN_VALUE;

		for (int j = 0; j <= N - K; j++) {
			int sum = 0;

			for (int i = j; i < j + K; i++) {
				sum += inputArray[i];
			}

			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}

}
