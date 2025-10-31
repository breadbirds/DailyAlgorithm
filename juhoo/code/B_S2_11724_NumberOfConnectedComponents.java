package source_code;

import java.io.*;
import java.util.*;

public class B_S2_11724_NumberOfConnectedComponents {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int M = Integer.parseInt(st.nextToken()); // ������ ����
		boolean[] visited = new boolean[N + 1];

		// ���� ó��
		if (M == 0) {
			System.out.println(N);
			return;
		}

		// �׷��� �ʱ�ȭ
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// �׷����� ���� ������ ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		// DFS
		int result = 0;

		for (int i = 1; i < N + 1; i++) {
			boolean isAllVisited = true;

			for (int j = 0; j < graph[i].size(); j++) {
				if (visited[graph[i].get(j)] == false) {
					isAllVisited = false;
				}
			}

			if (isAllVisited == false) {
				result++;
				dfs(graph, visited, i);
			}
			
			// ������� ���� ���� ó��
			if(graph[i].size() == 0) {
				result++;
			}
		}

		System.out.println(result);

	}

	private static void dfs(List<Integer>[] graph, boolean[] visited, int num) {
		for (int next : graph[num]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(graph, visited, next);
			}
		}
	}

}
