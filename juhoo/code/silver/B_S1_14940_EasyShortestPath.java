package source_code;

import java.io.*;
import java.util.*;

public class B_S1_14940_EasyShortestPath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] target = new int[2]; // 2번 목표의 좌표

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					target = new int[] { i, j };
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int[][] dist = new int[N][M];

		queue.add(new int[] { target[0], target[1] }); // 목표 좌표 설정
		visited[target[0]][target[1]] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[1];
			int y = cur[0];

			for (int p = 0; p < 4; p++) {
				int nx = x + dx[p];
				int ny = y + dy[p];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && visited[ny][nx] == false && map[ny][nx] == 1) {
					dist[ny][nx] = dist[y][x] + 1;
					visited[ny][nx] = true;
					queue.add(new int[] { ny, nx });
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 갈 수 없는 곳인지 판별
				if (dist[i][j] == 0 && map[i][j] == 1) {
					sb.append("-1");
				} else {
					sb.append(dist[i][j]);
				}

				if (j != M - 1) {
					sb.append(" ");
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
