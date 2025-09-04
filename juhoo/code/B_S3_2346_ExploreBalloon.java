package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2346_ExploreBalloon {
	static class Node {
		int idx;
		int move;

		Node(int i, int m) {
			idx = i;
			move = m;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Node> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			Node n = new Node(i + 1, Integer.parseInt(st.nextToken()));
			dq.add(n);
		}

		while (true) {
			Node cur = dq.removeFirst();
			sb.append(cur.idx).append(' ');

			if (dq.isEmpty()) {
				break;
			}

			int k = cur.move;
			if (k < 0) {
				for (int i = 0; i < (-k); i++) {
					dq.addFirst(dq.removeLast());
				}
			} else {
				for (int i = 0; i < k - 1; i++) {
					dq.addLast(dq.removeFirst());
				}
			}
		}

		System.out.println(sb);
	}

}
