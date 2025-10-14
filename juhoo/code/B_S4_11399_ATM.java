package source_code;

import java.io.*;
import java.util.*;

public class B_S4_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] input = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(input);

		// 순서대로 시간 계산
		int lastTime = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += lastTime + input[i];
			lastTime = lastTime + input[i];
		}

		System.out.println(sum);
	}
}
