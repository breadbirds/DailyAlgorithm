package source_code;

import java.io.*;
import java.util.*;

public class B_S3_20301_반전요세푸스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int cnt = 0;
		int idx = 0;
		int n = 0;

		while (!list.isEmpty()) {
			if (cnt < M) { // 순방향
				idx = (idx + K - 1 < list.size()) ? idx + K - 1 : (idx + K - 1) % list.size();
				n = list.get(idx);
				list.remove(idx);
				sb.append(n).append("\n");
				cnt++;
			} else if (cnt < M * 2) { // 역방향
				idx = (idx - K % list.size() + list.size()) % list.size();
				n = list.get(idx);
				list.remove(idx);
				sb.append(n).append("\n");
				cnt++;
			} else {
				cnt = 0;
			}

		}

		System.out.println(sb);
	}

}
