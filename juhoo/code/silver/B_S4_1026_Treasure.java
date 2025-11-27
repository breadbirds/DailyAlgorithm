package source_code;

import java.io.*;
import java.util.*;

public class B_S4_1026_Treasure {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}

		// 배열 정렬
		Arrays.sort(A);
		Arrays.sort(B);

		// 결과 구하기
		int cal = 0;
		for (int i = 0; i < N; i++) {
			cal += A[i] * B[N - i - 1];
		}
		
		System.out.println(cal);
	}

}
