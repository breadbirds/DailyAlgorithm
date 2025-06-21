
- 문제 링크 : https://www.acmicpc.net/problem/1260

## 제출 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS_1260 {

	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int v = Integer.parseInt(split[2]);

		visited = new boolean[n];
		graph = new int[n][n];

		for (int i = 0; i < m; i++) {
			split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]) - 1;
			int y = Integer.parseInt(split[1]) - 1;

			graph[x][y] = graph[y][x] = 1;

		}

		dfs(v - 1, n);
		visited = new boolean[n];
		System.out.println();
		bfs(v - 1, n);
	}

	public static void dfs(int v, int n) {

		visited[v] = true;
		System.out.print(v + 1 + " ");

		for (int i = 0; i < n; i++) {
			if (graph[v][i] == 1 && !visited[i]) {
				dfs(i, n);
			}
		}
	}

	public static void bfs(int v, int n) {

		visited[v] = true;
		Queue<Integer> queue = new LinkedList<>();

		queue.add(v);
		while (!queue.isEmpty()) {

			v = queue.poll();
			System.out.print(v + 1 + " ");

			for (int i = 0; i < n; i++) {
				if (graph[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}

		}

	}

}
```