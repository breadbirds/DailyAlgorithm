package source_code;

import java.io.*;
import java.util.*;

public class B_S4_10816_NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] cards = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		long[] input = new long[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		// sort
		Arrays.sort(cards);

		// binary search
		for (int i = 0; i < M; i++) {
			// 시작점 찾기
			int left = 0;
			int right = N - 1;
			int start = 0;

			while (left <= right) {
				int mid = (right + left) / 2;

				if (input[i] > cards[mid]) {
					left = mid + 1;
				} else if (input[i] <= cards[mid]) {
					right = mid - 1;
					start = mid;
				}
			}

			// 끝 점 찾기
			left = 0;
			right = N - 1;
			int end = 0;

			while (left <= right) {
				int mid = (right + left) / 2;

				if (input[i] >= cards[mid]) {
					left = mid + 1;
					end = mid;
				} else if (input[i] < cards[mid]) {
					right = mid - 1;
				}
			}

			if (cards[end] == input[i] && cards[start] == input[i]) {
				sb.append(end - start + 1);
			} else {
				sb.append("0");
			}

			if (i != M - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);

	}

}
