package source_code;

import java.io.*;
import java.util.*;

public class B_S1_2667_NumberingComplexes {
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static List<Integer> result = new ArrayList<>();
	static int[][] apartment;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		apartment = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				apartment[i][j] = ch[j] - '0';
			}
		}

		// dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (apartment[j][i] == 1 && visited[j][i] == false) { // 출발점
					result.add(dfs(i, j));
				}
			}
		}

		// 정렬 후 출력
		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");

		for (int i : result) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int x, int y) {
		int houseCnt = 1;
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N && apartment[ny][nx] == 1 && visited[ny][nx] == false) {
				visited[ny][nx] = true;
				houseCnt += dfs(nx, ny);
			}
		}

		return houseCnt;
	}

}
