package source_code;

import java.io.*;
import java.util.*;

public class B_S2_5567_결혼식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 동기 수
		int m = Integer.parseInt(br.readLine()); // 리스트 길이

		// 인접 리스트 저장
		List<Integer>[] adjacencyList = new ArrayList[n + 1];

		// 초기화
		for (int i = 0; i < n + 1; i++) {
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjacencyList[a].add(b);
			adjacencyList[b].add(a);
		}

		// 인접 리스트 bfs 탐색
		// 시작점 큐에 저장
		Queue<Integer> startNodes = new LinkedList<>();
		boolean[] visited = new boolean[n + 1]; // 정점 방문 체크
		visited[1] = true;

		for (int i = 0; i < adjacencyList[1].size(); i++) {
			startNodes.add(adjacencyList[1].get(i));
			visited[adjacencyList[1].get(i)] = true;
		}

		int loopCnt = startNodes.size();

		// while(!startNodes.isEmpty())를 안 쓴 이유: 친구의 친구까지만 탐색해야 하기 때문
		for (int i = 0; i < loopCnt; i++) {
			int cur = startNodes.poll();

			for (int next : adjacencyList[cur]) {
				if (visited[next] == false) {
					startNodes.add(next);
					visited[next] = true;
				}
			}
		}

		// 결과 계산
		int result = 0;
		for (int i = 2; i < n + 1; i++) {
			if (visited[i] == true) {
				result++;
			}
		}

		System.out.println(result);
	}

}
