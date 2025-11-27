package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_S3_10974_AllPermutations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] addedNum = new int[N];
		StringBuilder sb = new StringBuilder();
		int[] visited = new int[N];

		dfs(N, 0, addedNum, sb, visited);

		System.out.println(sb);
	}

	private static void dfs(int n, int depth, int[] addedNum, StringBuilder sb, int[] visited) {
		if (depth == n) {
			for (int i = 0; i < n; i++) {
				sb.append(addedNum[i]);

				if (i != n - 1) {
					sb.append(" ");
				}
			}

			sb.append("\n");

			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i - 1] == 1)
				continue;

			visited[i - 1] = 1;
			addedNum[depth] = i;
			dfs(n, depth + 1, addedNum, sb, visited);
			visited[i - 1] = 0;
		}
	}

}
