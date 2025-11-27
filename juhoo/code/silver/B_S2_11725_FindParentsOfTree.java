package source_code;

import java.io.*;
import java.util.*;

public class B_S2_11725_FindParentsOfTree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] input = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			input[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			input[a].add(b);
			input[b].add(a);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < input[cur].size(); i++) {
				int next = input[cur].get(i);

				if (visited[next] == true) {
					continue;
				}

				queue.add(next);
				parent[next] = cur;
				visited[next] = true;
			}
		}

		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}
	}
}
