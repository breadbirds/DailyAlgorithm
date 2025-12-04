package source_code;

import java.io.*;
import java.util.*;

public class B_S3_9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < tc; testCase++) {
			int n = Integer.parseInt(br.readLine()); // 해빈이가 가진 의상 수

			Map<String, Integer> categoryMap = new HashMap<>();
			List<String> categoryList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();

				categoryMap.compute(category, (k, v) -> (v == null ? 1 : v + 1));
				if (!categoryList.contains(category)) {
					categoryList.add(category);
				}
			}

			// 각 카테고리 별 경우의 수 구하기
			int[] numberOfCases = new int[categoryMap.size()];
			for (int i = 0; i < categoryMap.size(); i++) {
				// 모든 옷은 입거나, 안입거나로 나뉨 -> 옷의 수 + 1 (다 안입는 경우)
				numberOfCases[i] = categoryMap.get(categoryList.get(i)) + 1;
			}

			// 전체 경우의 수 구하기
			// 각 카테고리 별 수를 서로 곱하기 - 1 (하나도 안 입는 경우는 뺌)
			int result = 1;
			for (int i = 0; i < numberOfCases.length; i++) {
				result *= numberOfCases[i];
			}

			System.out.println(result - 1);
		}
	}

}
