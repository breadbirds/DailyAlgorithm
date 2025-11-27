package source_code;

import java.io.*;
import java.util.*;

public class B_S4_14244_MakeTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 인접 리스트 만들기
		List<Integer>[] graph = new ArrayList[N];
		StringBuilder sb = new StringBuilder();

		if (M == 2) {
			for (int i = 0; i < N - 1; i++) {
				sb.append(i).append(" ").append(i + 1).append("\n");
			}
		} else {

			for (int i = 0; i < N - M; i++) {
				sb.append(i).append(" ").append(i + 1).append("\n");
			}

			for (int i = N - M + 1; i < N; i++) {
				sb.append(N - M).append(" ").append(i).append("\n");
			}
		}

		System.out.println(sb);
	}

}
