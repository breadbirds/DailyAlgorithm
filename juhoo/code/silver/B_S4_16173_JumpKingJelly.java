package source_code;

import java.io.*;
import java.util.*;

public class B_S4_16173_JumpKingJelly {
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static String result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] inputArray = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				inputArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = "Hing";

		dfs(N, inputArray, 0, 0, inputArray[0][0], 0);

		System.out.println(result);
	}

	private static void dfs(int n, int[][] inputArray, int x, int y, int value, int times) {
		if (x == n - 1 && y == n - 1) {
			result = "HaruHaru";
			return;
		}

		if (times == n * n) {
			result = "Hing";
			return;
		}

		for (int dir = 0; dir < 2; dir++) {
			int nx = x;
			int ny = y;

			for (int i = 0; i < value; i++) {
				nx += dx[dir];
				ny += dy[dir];
			}

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				dfs(n, inputArray, nx, ny, inputArray[ny][nx], times + 1);
			}
		}

	}

}
