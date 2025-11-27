package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1138_StandInALine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람 수
		int[] input = new int[N]; // 입력 수열
		List<Integer> list = new LinkedList<>(); // 출력 수열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// 뒤에서부터 숫자 결과 리스트에 넣기
		for (int i = N - 1; i >= 0; i--) {
			int idx = input[i]; // 왼쪽에서부터 떨어져야 하는 위치 (=왼쪽에 위치할 큰 사람 수)

			if (idx > list.size()) {
				idx = list.size() - 1;
			}

			list.add(idx, i + 1);
		}

		// 출력 문자열 만들기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i));

			if (i != N - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}
