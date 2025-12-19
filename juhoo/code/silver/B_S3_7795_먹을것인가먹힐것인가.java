package source_code;

import java.io.*;
import java.util.*;

public class B_S3_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케 개수
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // A의 수
			int M = Integer.parseInt(st.nextToken()); // B의 수
			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// 투포인터로 풀기
			int result = 0;
			Arrays.sort(A);
			Arrays.sort(B);

			for (int i = 0; i < N; i++) {
				int n = A[i];
				int left = 0;
				int right = M;
				int turnPoint = -1;

				while (left < right) {
					int mid = (left + right) / 2;

					if (n > B[mid]) {
						turnPoint = mid;
						left = mid + 1;
					} else {
						right = mid;
					}
				}

				if (turnPoint != -1) {
					result += turnPoint + 1;
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

}
