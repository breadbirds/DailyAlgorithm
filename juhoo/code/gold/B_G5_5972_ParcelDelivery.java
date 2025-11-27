package source_code;

import java.io.*;
import java.util.*;

// 최소한의 소들을 지나가자!

public class B_G5_5972_ParcelDelivery {
	static class Edge {
		int to;
		int cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간 개수
		int M = Integer.parseInt(st.nextToken()); // 소들의 길 개수

		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Edge(to, cost));
			graph.get(to).add(new Edge(from, cost));
		}

		int[] result = dijkstra(graph, 1);
		System.out.println(result[N]);
	}

	private static int[] dijkstra(List<List<Edge>> graph, int start) {
		int[] dist = new int[graph.size()];
		dist[1] = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int cost = cur[1];

			if (cost > dist[now]) {
				continue;
			}

			for (Edge e : graph.get(now)) {
				int nextCost = cost + e.cost;

				if (nextCost < dist[e.to]) {
					dist[e.to] = nextCost;
					pq.add(new int[] { e.to, nextCost });
				}
			}
		}

		return dist;
	}

}
