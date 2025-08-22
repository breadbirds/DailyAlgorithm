package source_code;

import java.io.*;
import java.util.*;

public class B_S3_16922_makeRomeNumber {
	static int[] numbers = { 1, 5, 10, 50 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> sum = new HashSet<>();
		int currentSum = 0;

		dfs(N, 0, sum, currentSum, 0);

		System.out.println(sum.size());
	}

	private static void dfs(int n, int depth, Set<Integer> sum, int currentSum, int start) {
		if (depth == n) {
			sum.add(currentSum);
			return;
		}

		for (int i = start; i < 4; i++) {
			currentSum += numbers[i];
			dfs(n, depth + 1, sum, currentSum, i);
			currentSum -= numbers[i];
		}
	}

}
