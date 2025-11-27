package source_code;

import java.io.*;
import java.util.*;

// 숫자 N개로 이루어진 수열
// 숫자는 C모다 작거나 같음
// 빈도순대로 정렬 (내림차순) -> 같다면 기존 순서대로

public class B_S3_2910_FrequencySort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		Map<Integer, Integer> frequency = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			frequency.put(num[i], frequency.getOrDefault(num[i], 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequency.entrySet());
		
		list.sort((e1, e2) -> {
			return e2.getValue() - e1.getValue();
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int freq = list.get(i).getValue();

			for (int j = 0; j < freq; j++) {
				sb.append(list.get(i).getKey());
				if (i != N - 1) {
					sb.append(" ");
				}
			}
		}

		System.out.println(sb);
	}
}
