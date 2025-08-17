package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_S3_15656_NandM7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];

		StringBuilder sb = new StringBuilder();
		int[] addedNum = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		// 미리 오름차순 정렬
		Arrays.sort(numbers);
		int index = 0;

		dfs(0, N, M, sb, addedNum, numbers, index);

		System.out.println(sb);
	}

	private static void dfs(int depth, int n, int m, StringBuilder sb, int[] addedNum, int[] numbers, int index) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(addedNum[i]);
				if (i != m - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			index = (index == m) ? 0 : index;

			addedNum[index] = numbers[i];
			dfs(depth + 1, n, m, sb, addedNum, numbers, index + 1);
			addedNum[index] = 0;
		}
	}

}
