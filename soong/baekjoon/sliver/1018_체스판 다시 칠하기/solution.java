import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static boolean[][] visited;
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = split[j].charAt(0);
			}
		}

		visited = new boolean[N][M];
		cnt = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				ans = Math.min(ans, check(i, j));
			}
		}

		System.out.println(ans);
	}

	static int cnt;

	static int check(int x, int y) {
		int repaintW = 0; // 왼쪽 위가 W인 체스판 기준
		int repaintB = 0; // 왼쪽 위가 B인 체스판 기준

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				char current = map[i][j];

				// (i+j) % 2 == 0 → 왼쪽 위와 같은 색
				if ((i + j) % 2 == 0) {
					if (current != 'W')
						repaintW++;
					if (current != 'B')
						repaintB++;
				} else { // (i+j) % 2 == 1 → 왼쪽 위와 반대 색
					if (current != 'B')
						repaintW++;
					if (current != 'W')
						repaintB++;
				}
			}
		}

		return Math.min(repaintW, repaintB);
	}
}
