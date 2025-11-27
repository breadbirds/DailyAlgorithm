package source_code;

import java.io.*;
import java.util.*;

public class B_S2_4963_NumberOfIslands {
	static int w;
	static int h;
	static boolean[][] visited;
	static int[][] map;
	static final int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static final int[] dy = { 0, 0, 1, -1, -1, -1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken()); // 지도의 너비
		h = Integer.parseInt(st.nextToken()); // 지도의 높이
		StringBuilder sb = new StringBuilder();

		while (w != 0 && h != 0) {
			map = new int[h][w];
			visited = new boolean[h][w];

			// 입력 받기
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs 탐색
			int islandCnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						visited[i][j] = true;
						dfs(j, i);
						islandCnt++;
					}
				}
			}

			// 출력
			sb.append(islandCnt).append("\n");

			// 재입력 받기
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < w && ny < h && !visited[ny][nx] && map[ny][nx] == 1) {
				visited[ny][nx] = true;
				dfs(nx, ny);
			}
		}
	}
}
