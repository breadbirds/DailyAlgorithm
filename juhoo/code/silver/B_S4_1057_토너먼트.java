package source_code;

import java.io.*;
import java.util.*;

public class B_S4_1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int jimin = Integer.parseInt(st.nextToken()); // 김지민 번호
		int hansu = Integer.parseInt(st.nextToken()); // 임한수 번호
		int round = 1;

		List<Integer> tournament = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			tournament.add(i);
		}

		while (N > 1) {
			// 토너먼트 대결
			int idx = 0;
			N = tournament.size();
			
			while (idx < N) {
				if (idx == N - 1) { // 홀수 -> 부전승
					break;
				} else {
					int a = tournament.get(idx);
					int b = tournament.get(idx + 1);

					// 김지민과 임한수라면 반복문 끝
					if ((a == jimin && b == hansu) || (a == hansu && b == jimin)) {
						System.out.println(round);
						return;
					}

					// 김지민과 임한수면 무조건 이김
					if (a == jimin || a == hansu) {
						tournament.remove(idx + 1);
					} else {
						tournament.remove(idx);
					}

				}

				idx++;
				N = tournament.size();
			}

			round++;
		}

		// 만나지 못했다면 -1 출력
		System.out.println(-1);

	}
}
