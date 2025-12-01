package source_code;

import java.io.*;
import java.util.*;

public class B_S1_1992_쿼드트리 {
	static int[][] input;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				input[i][j] = str[j] - '0';
			}
		}

		sb = new StringBuilder();
		sb.append("(");
		divideAndConquer(0, 0, N);
		sb.append(")");

		System.out.println(sb);
	}

	private static void divideAndConquer(int startX, int startY, int n) {
		// 현재 구역이 전부 한 숫자라면 빠른 return
		int value = input[startY][startX];
		boolean isFull = true;
		for (int i = startY; i < startY + n; i++) {
			for (int j = startX; j < startX + n; j++) {
				if (input[i][j] != value) {
					isFull = false;

				}
			}
		}

		if (isFull == true) {
			sb.append(value);
			return;
		}

		// 그게 아니라면 4등분
		sb.append("(");

		divideAndConquer(startX, startY, n / 2);
		divideAndConquer(startX + n / 2, startY, n / 2);
		divideAndConquer(startX, startY + n / 2, n / 2);
		divideAndConquer(startX + n / 2, startY + n / 2, n / 2);

		sb.append(")");
	}

}
