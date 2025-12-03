package source_code;

import java.io.*;
import java.util.*;

public class B_S2_24480_깊이우선탐색2 {
	static int N;
	static int M;
	static int R;
	static List<Integer>[] list;
	static int[] visited;
	static StringBuilder sb;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점
		sb = new StringBuilder();
		
		// 모든 가중치는 1

		list = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			if (visited[i] != 0) {
				sb.append(visited[i]);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int start) {
		visited[start] = cnt;

		for (int next : list[start]) {
			if (visited[next] == 0) {
				cnt += 1;
				dfs(next);
			}
		}
	}
}
