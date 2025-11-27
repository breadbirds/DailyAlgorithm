package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1012_OrganicCabbage {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
			int N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치 개수
			int[][] field = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			int result = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			// BFS
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						Queue<int[]> queue = new LinkedList<>();
						queue.add(new int[] { i, j });
						visited[0][0] = true;

						while (!queue.isEmpty()) {
							int[] cur = queue.poll();
							int y = cur[0];
							int x = cur[1];

							for (int d = 0; d < 4; d++) {
								int ny = y + dy[d];
								int nx = x + dx[d];

								if (ny >= 0 && nx >= 0 && ny < N && nx < M && field[ny][nx] == 1
										&& visited[ny][nx] == false) {
									visited[ny][nx] = true;
									queue.add(new int[] { ny, nx });
								}
							}
						}

						result++;

					}
				}
			}

			sb.append(result).append("\n");

		}

		System.out.println(sb);

	}

}
