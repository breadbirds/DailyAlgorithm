package source_code;

import java.io.*;
import java.util.*;

// bfs - 큐

public class B_G5_7569_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int H = Integer.parseInt(st.nextToken()); // 높이
		int[][][] input = new int[H][N][M];
		List<int[]> start = new ArrayList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					input[i][j][k] = Integer.parseInt(st.nextToken());

					if (input[i][j][k] == 1) {
						start.add(new int[] { i, j, k });
					}
				}
			}
		}

		if (start.isEmpty()) {
			System.out.println(-1);
			return;
		}

		// 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토 없음
		int[] dx = { 1, -1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, 1, -1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, 1, -1 };
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < start.size(); i++) {
			int[] arr = start.get(i);
			queue.add(new int[] { arr[0], arr[1], arr[2] });
		}

		int[][][] visited = new int[H][N][M]; // 일수 누적

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int h = cur[0];
			int y = cur[1];
			int x = cur[2];

			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (nh >= 0 && ny >= 0 && nx >= 0 && nh < H && ny < N && nx < M && input[nh][ny][nx] == 0
						&& visited[nh][ny][nx] == 0) {
					visited[nh][ny][nx] = visited[h][y][x] + 1;
					queue.add(new int[] { nh, ny, nx });
				}
			}
		}

		int result = 0;
		loop1: for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (visited[i][j][k] == 0 && input[i][j][k] == 0) {
						result = -1;
						break loop1;
					}
					if (result < visited[i][j][k]) {
						result = visited[i][j][k];
					}
				}
			}
		}

		System.out.println(result);
	}

}
