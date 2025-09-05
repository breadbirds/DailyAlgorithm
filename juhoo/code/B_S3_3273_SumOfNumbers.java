package source_code;

import java.io.*;
import java.util.*;

public class B_S3_3273_SumOfNumbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputArray = new int[N];

		for (int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int result = 0;

		Arrays.sort(inputArray);
		int limitIndex = -1;

		for (int i = 0; i < N; i++) {
			if (inputArray[i] > M) {
				limitIndex = i;
				break;
			}
		}

		int sum = 0;

		limitIndex = (limitIndex == -1) ? N : limitIndex;

		int left = 0;
		int right = N - 1;

		while (left < right) {
			sum = inputArray[left] + inputArray[right];

			if (sum > M) {
				right--;
			} else if (sum < M) {
				left++;
			} else {
				result++;
				left++;
				right--;
			}
		}

		System.out.println(result);
	}

}
