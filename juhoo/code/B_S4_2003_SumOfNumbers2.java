package source_code;

import java.io.*;
import java.util.*;

public class B_S4_2003_SumOfNumbers2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;

		st = new StringTokenizer(br.readLine());
		int[] inputList = new int[N];
		for (int i = 0; i < N; i++) {
			inputList[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			int j = i;

			while (sum <= M) {
				if (sum == M) {
					result++;
					break;
				} else if (j == N) {
					break;
				}

				sum += inputList[j++];
			}
		}

		System.out.println(result);
	}

}
