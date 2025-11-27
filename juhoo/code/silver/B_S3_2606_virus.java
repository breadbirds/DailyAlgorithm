package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2606_virus {
	static boolean[] visited;
	static int result = 0;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Computercnt = Integer.parseInt(br.readLine());
		int lineCnt = Integer.parseInt(br.readLine());
		visited = new boolean[Computercnt + 1];

		// 무방향 그래프 선언
		graph = new ArrayList[Computercnt + 1];
		for (int i = 1; i <= Computercnt; i++) {
			graph[i] = new ArrayList<>();
		}

		// 노드 저장
		for (int i = 0; i < lineCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

		}

		// 탐색 방식: DFS(덩어리 구하기)
		dfs(1);

		System.out.println(result);

	}

	private static void dfs(int i) {
		visited[i] = true;

		for (int next : graph[i]) {
			if (!visited[next]) {
				dfs(next);
				result++;
			}
		}
	}

}
