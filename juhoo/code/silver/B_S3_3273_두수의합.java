package source_code;

import java.io.*;
import java.util.*;

public class B_S3_3273_두수의합 {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		long x = Long.parseLong(br.readLine()); // 합이 되어야 하는 수
		int result = 0;

		// 오름차순 정렬
		Arrays.sort(input);

		// 투포인터로 찾기
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int sum = input[left] + input[right];

			if (sum < x) {
				left++;
			} else if (sum > x) {
				right--;
			} else {
				result++;
				left++;
			}
		}

		System.out.println(result);
	}

}
