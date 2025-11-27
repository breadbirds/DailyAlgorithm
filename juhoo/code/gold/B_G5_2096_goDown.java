package source_code;

import java.io.*;
import java.util.StringTokenizer;

// 1. 첫 줄의 세 가지 숫자 중 택 1
// 2. 내려갈 때는 바로 아래 or 아래 좌우로만 이동 가능

// 구해야 하는 것: 얻을 수 있는 최대 점수, 최소 점수

public class B_G5_2096_goDown {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 줄 개수
		int[][] input = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] max = new int[N + 1][4];
		int[][] min = new int[N + 1][4];

		for (int i = 1; i <= 3; i++) {
			max[1][i] = input[0][i - 1];
			min[1][i] = input[0][i - 1];
		}

		for (int i = 2; i <= N; i++) {
			// 왼쪽
			max[i][1] = Math.max(max[i - 1][1], max[i - 1][2]) + input[i - 1][0];
			min[i][1] = Math.min(min[i - 1][1], min[i - 1][2]) + input[i - 1][0];

			// 중간
			max[i][2] = Math.max(max[i - 1][1], Math.max(max[i - 1][2], max[i - 1][3])) + input[i - 1][1];
			min[i][2] = Math.min(min[i - 1][1], Math.min(min[i - 1][2], min[i - 1][3])) + input[i - 1][1];

			// 오른쪽
			max[i][3] = Math.max(max[i - 1][2], max[i - 1][3]) + input[i - 1][2];
			min[i][3] = Math.min(min[i - 1][2], min[i - 1][3]) + input[i - 1][2];
		}

		int maxResult = 0;
		int minResult = Integer.MAX_VALUE;

		for (int i = 1; i <= 3; i++) {
			if (minResult > min[N][i]) {
				minResult = min[N][i];
			}
			if (maxResult < max[N][i]) {
				maxResult = max[N][i];
			}
		}

		System.out.println(maxResult + " " + minResult);
	}

}
