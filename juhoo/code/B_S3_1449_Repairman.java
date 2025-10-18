package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1449_Repairman {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
		int[] input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(input);
		int result = 1; // 테이프 개수
		int first = 0;

		for (int i = 1; i < N; i++) {
			if (input[i] - input[first] >= L) {
				result++;
				first = i;
			}
		}

		System.out.println(result);
	}
}
