package source_code;

import java.io.*;
import java.util.*;

public class B_G5_4803_Tree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int caseCnt = 0;

		while (true) {
			caseCnt++;

			List<Integer>[] input = new ArrayList[N + 1];
			int treeCnt = 0;
			boolean[] visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				input[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());

				input[n1].add(n2);
				input[n2].add(n1);
			}

			// bfs·Î Å½»ö
			for (int j = 1; j <= N; j++) {
				int e = 0;
				int v = 0;

				if (visited[j]) {
					continue;
				}

				boolean isTree = true;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(j);
				visited[j] = true;

				while (!queue.isEmpty()) {
					int cur = queue.poll();
					e++;

					for (int i = 0; i < input[cur].size(); i++) {
						v++;

						if (visited[input[cur].get(i)] == false) {
							queue.add(input[cur].get(i));
							visited[input[cur].get(i)] = true;
						}
					}
				}

				if (e - 1 == v / 2) {
					treeCnt++;
				}
			}

			if (treeCnt == 0) {
				System.out.println("Case " + caseCnt + ": No trees.");
			} else if (treeCnt == 1) {
				System.out.println("Case " + caseCnt + ": There is one tree.");
			} else {
				System.out.println("Case " + caseCnt + ": A forest of " + treeCnt + " trees.");
			}

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) {
				break;
			}
		}

	}

}
