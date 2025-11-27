package source_code;

import java.io.*;
import java.util.*;

public class B_S2_10819_maximumDifference {
	static int result;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] numList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;
		int[] addedNum = new int[N];
		visited = new int[N];
		findMaxResult(numList, N, 0, addedNum);

		System.out.println(result);
	}

	private static void findMaxResult(int[] numList, int n, int depth, int[] addedNum) {
		if (depth == n) {
			int cal = 0;
			for (int i = 0; i < n - 1; i++) {
				cal += Math.abs(addedNum[i] - addedNum[i + 1]);
			}

			result = Math.max(cal, result);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == 1)
				continue;

			addedNum[depth] = numList[i];
			visited[i] = 1;

			findMaxResult(numList, n, depth + 1, addedNum);

			visited[i] = 0;
		}
	}

}
