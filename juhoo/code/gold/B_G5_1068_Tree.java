package source_code;

import java.io.*;
import java.util.*;

public class B_G5_1068_Tree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> tree = new ArrayList<>();
		List<Integer> origin = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			tree.add(i, n);
		}

		int removeNum = Integer.parseInt(br.readLine());
		int leafCnt = 0;

		// 해당 노드 및 자식 노드들 삭제
		Queue<Integer> queue = new LinkedList<>();
		queue.add(removeNum);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			tree.set(cur, -2);

			for (int i = 0; i < N; i++) {
				if (tree.get(i) == cur) {
					queue.add(i);
				}
			}
		}

		origin = new ArrayList<>(tree);

		// 부모로 지정된 인덱스 전부 삭제
		for (int i = 0; i < N; i++) {
			int cur = i;

			for (int j = 0; j < N; j++) {
				if (cur == origin.get(j)) {
					tree.set(cur, -2);
				}
			}
		}

		// -1이 아닌 인덱스 수 구하기
		boolean hasRoot = false;

		for (int i = 0; i < N; i++) {
			if (tree.get(i) >= 0) {
				leafCnt++;
			} else if (tree.get(i) == -1) {
				hasRoot = true;
			}
		}

		// 루트밖에 없는 트리가 되었다면 리프는 1
		if (leafCnt == 0 && hasRoot) {
			leafCnt = 1;
		}

		System.out.println(leafCnt);

	}

}
