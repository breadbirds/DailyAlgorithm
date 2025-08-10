package source_code;

import java.util.Scanner;

public class B_S2_1182_subSequenceSum {
	static int N;
	static int S;
	static int result;
	static int[] numList;
	static int[] visited;
	static int turnCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		numList = new int[N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			numList[i] = sc.nextInt();
		}

		result = 0;
		turnCnt = 0;

		if (N == 1 && S == numList[0]) {
			result = 1;
		} else {
			findSubSequence(0, -1);
		}

		System.out.println(result);
	}

	private static void findSubSequence(int sum, int prevIndex) {
		if (sum == S && turnCnt != 0) {
			result++;
			turnCnt = 0;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 1 || i <= prevIndex)
				continue;

			visited[i] = 1;
			turnCnt++;

			findSubSequence(sum + numList[i], i);
			visited[i] = 0;
		}
	}

}
