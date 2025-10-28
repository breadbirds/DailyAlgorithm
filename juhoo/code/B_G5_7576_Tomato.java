package source_code;

import java.io.*;
import java.util.*;

public class B_G5_7576_Tomato {
	public static void main(String[] args) throws IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		int N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		int[][] box = new int[N][M];
		List<int[]> start = new ArrayList<>();
		int zeroCnt = 0;
		int minusCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // 시작점 선택
					start.add(new int[] { i, j });
				} else if (box[i][j] == 0) {
					zeroCnt++;
				} else if (box[i][j] == -1) {
					minusCnt++;
				}

			}
		}

		// 예외처리1: 모두 익어있거나 익어있는 게 하나도 없는 상태
		if (start.size() == M * N - minusCnt) {
			System.out.println(0);
			return;
		} else if (zeroCnt == M * N - minusCnt) {
			System.out.println(-1);
			return;
		}

		// BFS
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < start.size(); i++) {
			queue.add(start.get(i));
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[1];
			int y = cur[0];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && box[ny][nx] == 0) {
					box[ny][nx] = box[y][x] + 1;
					queue.add(new int[] { ny, nx });
				}
			}
		}

		int dayCnt = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) { // 예외처리2: 다 익을 수 없는 경우
					System.out.println(-1);
					return;
				}
				dayCnt = Math.max(dayCnt, box[i][j]);
			}
		}

		System.out.println(dayCnt - 1);

	}

}
