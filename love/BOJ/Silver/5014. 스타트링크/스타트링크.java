import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 풀이 전략 - BFS
 * 
 * 오답 과정 - 초반에 무한반복으로 인한 오류가 발생했는데, 함수재호출 과정에서 이미 방문한 층에 다시 가는 경우를 고려하지 못했음 예를
 * 들어 S=1, U=1, D=1 일 때, 1-> 2-> 1-> 2... 순서로 층 이동이 반복되겍 된다. - 정답을 갱신하기 위한 변수나
 * cnt++ -> cnt+1 과 같은 사소한 실수
 * 
 * - 초반에 DFS 로 풀었으나, 계속되는 오류로 찾아보니 무조건 BFS 로 풀어가 가능한 문제였음 ㅜㅜ - 01:30
 */

public class Main {

	public static int F, S, G, U, D, answer;
	public static boolean[] visited;

	static class Node {
		int floor;
		int count;

		Node(int floor, int count) {
			this.floor = floor;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 건물은 1층 부터 시작(시작위치는 S), 최대 F층 까지 존재
		F = Integer.parseInt(st.nextToken()); // 건물 층 수
		S = Integer.parseInt(st.nextToken()); // 시작 위치
		G = Integer.parseInt(st.nextToken()); // 목적지
		U = Integer.parseInt(st.nextToken()); // 위로 올라가는 버튼
		D = Integer.parseInt(st.nextToken()); // 아래로 내려가는 버튼
		visited = new boolean[F + 1];

		answer = Integer.MAX_VALUE;

		int result = bfs();

		// 출력
		if (result == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(S, 0));
		visited[S] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.floor == G) {
				return now.count;
			}

			// 위로 이동
			int up = now.floor + U;
			if (up <= F && !visited[up]) {
				visited[up] = true;
				queue.offer(new Node(up, now.count + 1));
			}

			// 아래로 이동
			int down = now.floor - D;
			if (down >= 1 && !visited[down]) {
				visited[down] = true;
				queue.offer(new Node(down, now.count + 1));
			}
		}

		return -1; // 도달 불가
	}
}