package source_code;

import java.io.*;
import java.util.*;

public class B_S1_2178_MazeNavigation {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mazeArray = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] inputArray = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				mazeArray[i][j] = Integer.parseInt(inputArray[j]);
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 }); // 시작점 넣기
		visited[0][0] = true;
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll(); // 먼저 들어온 칸 꺼내기

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[1] + dx[dir];
				int ny = cur[0] + dy[dir];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && mazeArray[ny][nx] == 1 && visited[ny][nx] == false) {
					queue.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
				}
			}
		}

		System.out.println(dist[N - 1][M - 1]);
	}

}
