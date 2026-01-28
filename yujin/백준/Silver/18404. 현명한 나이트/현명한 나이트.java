import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열 크기
		int M = Integer.parseInt(st.nextToken()); // 상대 말 개수
		int arr[][] = new int[N][N]; // N*N 체스판
		// 현재 나이트 위치 (x,y)
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		// 상대편 말의 위치(A,B)
		int[][] horse = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			horse[i][0] = Integer.parseInt(st.nextToken()); // A
			horse[i][1] = Integer.parseInt(st.nextToken()); // B

		}

		// 거리 배열
		int[][] dist = new int[N + 1][N + 1];
		boolean[][] visited = new boolean[N + 1][N + 1];

		// 나이트 방향 이동
		int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// BFS 큐
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { X, Y });
		visited[X][Y] = true;
		dist[X][Y] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위 체크 및 방문하지 않은 곳인지 확인
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
					queue.offer(new int[] { nx, ny });
				}
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int targetX = horse[i][0];
			int targetY = horse[i][1];
			sb.append(dist[targetX][targetY]);
			if (i < M - 1)
				sb.append(" ");
		}

		System.out.println(sb.toString());
	}

}