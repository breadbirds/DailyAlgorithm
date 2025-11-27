package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1021_RotateQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		int result = 0;

		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			// 왼쪽이 가까운지 오른쪽이 가까운지 판단
			int left = 0;
			int right = 0;
			Iterator<Integer> it = dq.iterator();

			while (it.hasNext()) {
				int n = it.next();
				if (n == num) {
					break;
				}
				left++;
			}

			while (it.hasNext()) {
				it.next();
				right++;
			}

			if (left > right) { // 오른쪽으로 밀기
				while (dq.getFirst() != num) {
					dq.addFirst(dq.removeLast());
					result++;
				}
			} else {
				while (dq.getFirst() != num) {
					dq.addLast(dq.removeFirst());
					result++;
				}
			}

			dq.removeFirst();
		}

		System.out.println(result);

	}

}
