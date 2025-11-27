package source_code;

import java.io.*;
import java.util.*;

public class B_S1_20922_IHateOverlaps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정수 개수
		int K = Integer.parseInt(st.nextToken()); // 반복 가능 횟수
		int[] input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int maxLen = 1; // 현재까지의 max length
		int first = 0;
		int last = 0;
		Map<Integer, Integer> map = new HashMap<>(); // same number's cnt
		int idx = 0;

		while (idx < N) {
			int num = input[idx];

			map.compute(num, (k, v) -> (v == null) ? 1 : v + 1);

			if (map.get(num) > K) { // over
				// first를 뒤로 당기기
				while (first < last) {
					if (map.get(num) == null || map.get(num) <= K) {
						break;
					}

					map.compute(input[first], (k, v) -> v - 1);
					first++;
				}
			}

			idx++;
			maxLen = Math.max(maxLen, (last - first + 1));
			last++;

//			System.out.println("first: " + first + " / last: " + last);
		}

		System.out.println(maxLen);
	}
}
