package source_code;

import java.io.*;
import java.util.*;

// 잃는 금액 최소 -> 동굴 건너편까지 이동
// 상하좌우 이동 가능

public class B_G4_4485_TheOneInGreenIsZelda {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		int N = Integer.parseInt(br.readLine()); // 동굴의 크기

		while (N != 0) {
			tc++;
			int[][] cave = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] result = dijkstra(N, cave);

			System.out.println("Problem " + tc + ": " + result[N - 1][N - 1]);

			N = Integer.parseInt(br.readLine());
		}
	}

	private static int[][] dijkstra(int n, int[][] cave) {
		int[][] result = new int[n][n]; // 비용 저장
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
		}
		result[0][0] = cave[0][0];

		// {x, y, 가중치}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		pq.add(new int[] { 0, 0, result[0][0] });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];

			if (cost > result[y][x]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (ny < 0 || nx < 0 || nx >= n || ny >= n) {
					continue;
				}

				int nextCost = cost + cave[ny][nx];

				if (nextCost < result[ny][nx]) {
					result[ny][nx] = nextCost;
					pq.add(new int[] { nx, ny, nextCost });
				}
			}
		}

		return result;
	}

}
