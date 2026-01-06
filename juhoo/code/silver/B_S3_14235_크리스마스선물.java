package source_code;

import java.io.*;
import java.util.*;

public class B_S3_14235_크리스마스선물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			// 아이들에게 선물 주기
			if (a == 0) {
				if (pq.isEmpty()) { // 줄 선물이 없을 경우
					sb.append(-1);
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else { // 거점에서 선물 get
				for (int j = 0; j < a; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}

		System.out.println(sb);
	}

}
