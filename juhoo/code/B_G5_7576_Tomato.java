package source_code;

import java.io.*;
import java.util.*;

public class B_G5_7576_Tomato {
	public static void main(String[] args) throws IOException {
		// �Է� �ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // ���� ĭ�� ��
		int N = Integer.parseInt(st.nextToken()); // ���� ĭ�� ��
		int[][] box = new int[N][M];
		List<int[]> start = new ArrayList<>();
		int zeroCnt = 0;
		int minusCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // ������ ����
					start.add(new int[] { i, j });
				} else if (box[i][j] == 0) {
					zeroCnt++;
				} else if (box[i][j] == -1) {
					minusCnt++;
				}

			}
		}

		// ����ó��1: ��� �;��ְų� �;��ִ� �� �ϳ��� ���� ����
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
				if (box[i][j] == 0) { // ����ó��2: �� ���� �� ���� ���
					System.out.println(-1);
					return;
				}
				dayCnt = Math.max(dayCnt, box[i][j]);
			}
		}

		System.out.println(dayCnt - 1);

	}

}
