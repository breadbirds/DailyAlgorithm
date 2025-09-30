package source_code;

import java.io.*;
import java.util.*;

public class B_S2_2304_WarehousePolygon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		int[][] pillar = new int[N][2]; // 기둥의 x축 위치와 높이

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillar[i][0] = Integer.parseInt(st.nextToken()); // x축 위치
			pillar[i][1] = Integer.parseInt(st.nextToken()); // 높이
		}

		// x축 좌표 기준으로 오름차순 정렬
		Arrays.sort(pillar, (s1, s2) -> {
			return Integer.compare(s1[0], s2[0]);
		});

		int area = 0; // 결과
		int[] prev = pillar[0]; // 이전 max 기둥 정보
		int idx = 0;

		if (N == 1) {
			area = prev[1];
		} else {
			for (int i = 1; i < N; i++) {
				int height = pillar[i][1];
				int x = pillar[i][0];

				// 더 높은 높이가 나오면 면적 넓이 추가
				if (height >= prev[1]) {
					area += (x - prev[0]) * prev[1];
					prev = pillar[i]; // 갱신
					idx = i;
				}
			}

			// max 뒷 부분 계산
			area += prev[1];

			prev = pillar[N - 1];

			for (int i = N - 2; i >= idx; i--) {
				int height = pillar[i][1];
				int x = pillar[i][0];

				// 더 높은 높이가 나오면 면적 넓이 추가
				if (height >= prev[1]) {
					area += (prev[0] - x) * prev[1];
					prev = pillar[i]; // 갱신
				}
			}

		}

		System.out.println(area);
	}
}
