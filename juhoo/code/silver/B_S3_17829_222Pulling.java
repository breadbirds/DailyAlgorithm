package source_code;

import java.io.*;
import java.util.*;

// 1. 2x2 행렬로 나누기
// 2. 각 행렬에서 두 번째로 큰 수만 남겨서 합치기
// 3. 전체 크기가 1x1이 될 때까지 반복

// 분할과 정복

public class B_S3_17829_222Pulling {
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 2의 거듭제곱
		int[][] input = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DevideAndConquer(input);

		System.out.println(result);
	}

	private static void DevideAndConquer(int[][] input) {
		if (input.length == 1) {
			result = input[0][0];
			return;
		}

		int[][] nextArr = new int[input.length / 2][input.length / 2];
		int nx = 0;
		int ny = 0;

		for (int i = 0; i < input.length - 1; i += 2) {
			// 4개의 값 중에서 두 번째로 큰 값을 찾아서 대체
			for (int j = 0; j < input.length - 1; j += 2) {
				int[] arr = new int[4];
				arr[0] = input[i][j];
				arr[1] = input[i][j + 1];
				arr[2] = input[i + 1][j];
				arr[3] = input[i + 1][j + 1];

				Arrays.sort(arr);

				nextArr[ny][nx++] = arr[2];
			}
			ny++;
			nx = 0;
		}

		input = nextArr;
		DevideAndConquer(nextArr);
	}

}
