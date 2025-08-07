package source_code;

import java.util.Scanner;

// �ּ� ���� ���
// ��, ����, �� �̵� ����

public class B_17484_JinwooMoonTrip {
	static int[] dx = { -1, 0, 1 };
	static int N = 0;
	static int M = 0;
	static int result = Integer.MAX_VALUE;
	static int[][] space;

	public static void main(String[] args) {
		// �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		space = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				space[i][j] = sc.nextInt();
			}
		}

		// DFS ���� Ž�� �ǽ�
		for (int j = 0; j < M; j++) {
			dfs(0, j, space[0][j], -1);
		}

		System.out.println(result);

	}

	private static void dfs(int y, int x, int sum, int prevDir) {
		if (y == N - 1) {
			result = Math.min(result, sum);
			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			if (dir == prevDir)
				continue; // ���� ���� ���� �Ұ���

			int ny = y + 1;
			int nx = x + dx[dir];

			if (nx < 0 || nx >= M)
				continue;

			dfs(ny, nx, sum + space[ny][nx], dir);
		}
	}

}
