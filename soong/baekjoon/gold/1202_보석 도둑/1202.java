import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static class Node implements Comparable<Node> {
		int m, v;

		public Node(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			int cmp = Integer.compare(this.m, o.m); // 무게는 낮지만, 가격은 높은 것
			if (cmp == 0) {
				return Integer.compare(o.v, this.v);
			}
			return cmp;
		}

		@Override
		public String toString() {
			return "(" + m + ", " + v + ")";
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		Node[] jewel = new Node[N];
		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");

			int M = Integer.parseInt(split[0]); // 무게
			int V = Integer.parseInt(split[1]); // 가격
			jewel[i] = new Node(M, V);

		}

		Arrays.sort(jewel, Comparator.comparingInt(a -> a.m));

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine()); // 최대 무게
			bags[i] = C;
		}

		Arrays.sort(bags);
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.v - a.v); // 가격 내림차순

		long price = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && jewel[idx].m <= bags[i]) {
				pq.offer(jewel[idx++]);
			}
			
			if (!pq.isEmpty()) {
				price += pq.poll().v;
			}
		}

		System.out.println(price);
	}

}