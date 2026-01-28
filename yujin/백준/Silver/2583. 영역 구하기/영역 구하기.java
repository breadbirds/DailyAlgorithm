import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int K;
	static int arr[][];
	static int leftX;
	static int leftY;
	static int rightX;
	static int rightY;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			leftX = Integer.parseInt(st.nextToken());
			leftY = Integer.parseInt(st.nextToken());
			rightX = Integer.parseInt(st.nextToken());
			rightY = Integer.parseInt(st.nextToken());

			for (int y = leftY; y < rightY; y++) {
				for (int x = leftX; x < rightX; x++) {
					arr[y][x] = 1;
				}
			}
		}

		// 영역의 크기를 저장할 공간이 필요
		ArrayList<Integer> areas = new ArrayList<>();

		// BFS 탐색
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0 && !visited[i][j]) {
					areas.add(bfs(i, j));
				}
			}
		}

		// 오름차순 정렬
		Collections.sort(areas);
		System.out.println(areas.size());
		for (int area : areas) {
			System.out.print(area + " ");
		}

	}

	private static Integer bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		int areaSize = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			areaSize++;

			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] == true || arr[nx][ny] == 1) {
					continue;
				}
				queue.offer(new int[] { nx, ny });
				visited[nx][ny] = true;
			}

		}
		return areaSize;
	}

}