package source_code;

import java.io.*;
import java.util.*;

// A -> B 비용 최소화

public class B_G5_1916_FindingTheMinimumCost {
	// 그래프 간선 표현 그래프
	static class Edge {
		int to, cost; // 도착 노드, 간선 가중치

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수

		// 1. 인접 리스트 저장 (방향 그래프)
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Edge(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken()); // 출발 도시번호
		int endCity = Integer.parseInt(st.nextToken()); // 도착 도시번호

		// 2. 최단 거리 다익스트라로 계산하기
		int[] result = dijkstra(graph, startCity);

		System.out.println(result[endCity]);
	}

	// 다익스트라 알고리즘
	private static int[] dijkstra(List<List<Edge>> graph, int start) {
		int n = graph.size();
		int[] dist = new int[n]; // 최단 거리 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 무한대로 초기화
		dist[start] = 0; // 시작점은 거리 0

		// (노드, 현재까지 비용) -> 비용 오름차순으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0], cost = cur[1];

			if (dist[now] < cost)
				continue;

			for (Edge e : graph.get(now)) {
				int nextCost = cost + e.cost;

				if (nextCost < dist[e.to]) {
					dist[e.to] = nextCost;
					pq.offer(new int[] { e.to, nextCost });
				}
			}
		}

		return dist;
	}

}
