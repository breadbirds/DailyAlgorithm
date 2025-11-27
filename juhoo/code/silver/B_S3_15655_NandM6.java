package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B_S3_15655_NandM6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int N = Integer.parseInt(s.split(" ")[0]);
		int M = Integer.parseInt(s.split(" ")[1]);

		s = br.readLine();
		int[] numList = new int[N];

		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(s.split(" ")[i]);
		}
		
		// 오름차순 출력을 위한 사전 정렬
		Arrays.sort(numList);

		StringBuffer sb = new StringBuffer();
		List<Integer> addedNum = new ArrayList<>();

		dfs(N, M, sb, addedNum, 0, 0, numList);

		System.out.println(sb);
	}

	private static void dfs(int n, int m, StringBuffer sb, List<Integer> addedNum, int start, int depth,
			int[] numList) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(addedNum.get(i));

				if (i != (m - 1)) {
					sb.append(" ");
				}
			}

			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) {
			
			// list에 추가
			addedNum.add(numList[i]);

			// 재귀
			dfs(n, m, sb, addedNum, i + 1, depth + 1, numList);

			// 백트래킹
			addedNum.remove(addedNum.size() - 1);
		}
	}
}
