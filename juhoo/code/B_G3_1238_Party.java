package source_code;

import java.io.*;
import java.util.*;

// 단방향 간선
// 가장 많은 시간 소비 학생 구하기

public class B_G3_1238_Party {
	static class Edge {
		int to;
		int time;

		Edge(int to, int time) {
			this.to = to;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 도로 개수
		int X = Integer.parseInt(st.nextToken()); // 학생들이 모인 마을
		List<List<Edge>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Edge(to, time));
		}

		int max = 0;
		int[] result2 = dijkstra(graph, X); // 돌아오는 길

		for (int i = 1; i <= N; i++) {
			int[] result = dijkstra(graph, i); // 가는 길

			if (result[X] + result2[i] > max) {
				max = result[X] + result2[i];
			}
		}

		System.out.println(max);
	}

	private static int[] dijkstra(List<List<Edge>> graph, int start) {
		int[] dist = new int[graph.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int time = cur[1];

			if (time > dist[now]) {
				continue;
			}

			for (Edge e : graph.get(now)) {
				int nextTime = time + e.time;

				if (nextTime < dist[e.to]) {
					dist[e.to] = nextTime;
					pq.add(new int[] { e.to, nextTime });
				}
			}
		}

		return dist;
	}

}
