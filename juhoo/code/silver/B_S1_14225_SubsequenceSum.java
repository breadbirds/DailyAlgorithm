package source_code;

import java.io.*;
import java.util.*;

public class B_S1_14225_SubsequenceSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] s = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		// 만들 수 있는 부분 수열 합 구하기
		List<Integer> sumList = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int[] addedNum = new int[i];

			findSubsequence(sumList, s, i, 0, addedNum, 0);
		}

		// 리스트 오름차순 정렬
		Collections.sort(sumList);

		//System.out.println(sumList);

		// 리스트에서 가장 작은 빈 숫자 찾기
		int result = 0;
		int current = 1;

		for (int i = 0; i < sumList.size(); i++) {
			if (sumList.get(i) < current)
				continue; // 작은 값은 건너뛰기

			if (current != sumList.get(i)) {
				result = current;
				break;
			}

			if (i == sumList.size() - 1) {
				result = sumList.get(i) + 1;
				break;
			}

			if (i != sumList.size() - 1 && sumList.get(i) != sumList.get(i + 1)) {
				current++;
			}
		}

		System.out.println(result);
	}

	private static void findSubsequence(List<Integer> sumList, int[] s, int n, int depth, int[] addedNum, int start) {
		if (depth == n) {
			// 합 구해서 리스트에 저장
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += addedNum[i];
			}
			sumList.add(sum);
			return;
		}

		for (int i = start; i < s.length; i++) {
			addedNum[depth] = s[i];
			findSubsequence(sumList, s, n, depth + 1, addedNum, i + 1);
		}
	}

}
