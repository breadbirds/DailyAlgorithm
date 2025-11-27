package source_code;

import java.io.*;
import java.util.*;

public class B_S2_3085_CandyGame {
	static int result = 0;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] input = new String[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				input[i][j] = str[j];
			}
		}

		solve(0, 0, input, N);

		System.out.println(result);
	}

	private static void solve(int x, int y, String[][] input, int N) {
		if (findLongest(input) == N) {
			result = N;
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (input[i][j].equals(input[i][j + 1])) {
					continue;
				} else {
					swap(i, j, i, j + 1, input);
					result = Math.max(result, findLongest(input));
					swap(i, j, i, j + 1, input);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (input[j][i].equals(input[j + 1][i])) {
					continue;
				} else {
					swap(j, i, j + 1, i, input);
					result = Math.max(result, findLongest(input));
					swap(j, i, j + 1, i, input);
				}
			}
		}
	}

	private static int findLongest(String[][] input) {
		int cnt = 1;
		int longest = 0;

		for (int i = 0; i < input.length; i++) {
			cnt = 1;
			for (int j = 0; j < input.length - 1; j++) {
				if (input[i][j].equals(input[i][j + 1])) {
					cnt++;
				} else {
					cnt = 1;
				}

				longest = Math.max(longest, cnt);
			}
		}

		for (int i = 0; i < input.length; i++) {
			cnt = 1;
			for (int j = 0; j < input.length - 1; j++) {
				if (input[j][i].equals(input[j + 1][i])) {
					cnt++;
				} else {
					cnt = 1;
				}

				longest = Math.max(longest, cnt);
			}
		}
		return longest;
	}

	private static void swap(int x, int y, int nx, int ny, String[][] input) {
		String str = input[x][y];
		input[x][y] = input[nx][ny];
		input[nx][ny] = str;
	}

}
