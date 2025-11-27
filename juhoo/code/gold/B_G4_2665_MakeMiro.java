package source_code;

import java.io.*;
import java.util.*;

public class B_G4_2665_MakeMiro {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 한 줄에 들어가는 방의 수
		int[][] rooms = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				// 1과 0 반대로 변경
				if ((str[j] - '0') == 0) {
					rooms[i][j] = 1;
				} else {
					rooms[i][j] = 0;
				}
			}
		}

		int ans = dijkstra(n, rooms);

		System.out.println(ans);
	}

	private static int dijkstra(int n, int[][] rooms) {
		int[][] dist = new int[n][n]; // 비용 측정 배열
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;

		// {x, y, cost}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		pq.add(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}

				int nextCost = cost + rooms[ny][nx];
				if (nextCost < dist[ny][nx]) {
					dist[ny][nx] = nextCost;
					pq.add(new int[] { nx, ny, nextCost });
				}
			}
		}

		return dist[n - 1][n - 1];
	}

}
