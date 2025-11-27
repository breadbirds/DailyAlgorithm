package source_code;

import java.io.*;
import java.util.*;

public class B_S4_1920_FindNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] comparison = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			comparison[i] = Integer.parseInt(st.nextToken());
		}

		// sort
		Arrays.sort(input);

		// binary Search
		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			boolean contains = false;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (comparison[i] < input[mid]) {
					right = mid - 1;
				} else if (comparison[i] > input[mid]) {
					left = mid + 1;
				} else if (comparison[i] == input[mid]) {
					contains = true;
					break;
				}
			}

			if (contains == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

}
