package source_code;

import java.io.*;
import java.util.*;

public class B_S1_1325_EfficientHacking {
	static int cnt = 0;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		List<Integer>[] graph = new ArrayList[N + 1];

		// 그래프 초기화
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 채우기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 방향 O
			graph[B].add(A);
		}

		// BFS
		int max = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			int cal = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			boolean[] visited = new boolean[N + 1];

			if (!visited[i]) {
				visited[i] = true;
				
				while (!queue.isEmpty()) {
					int cur = queue.poll();

					for (int n : graph[cur]) {
						if (!visited[n]) {
							cal++;
							visited[n] = true;
							queue.add(n);
						}
					}
				}

				if (max < cal) {
					max = cal;
					result.clear();
					result.add(i);
				} else if (max == cal) {
					result.add(i);
				}
			}
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}
