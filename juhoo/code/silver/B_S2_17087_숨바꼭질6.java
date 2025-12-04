package source_code;

import java.io.*;
import java.util.*;

public class B_S2_17087_숨바꼭질6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동생 N명
		int S = Integer.parseInt(st.nextToken()); // 수빈이의 현재 위치
		// 구해야 하는 것: D 최댓값(한 번에 이동할 수 있는 거리)

		int[] siblings = new int[N];
		// 각 동생들과 수빈이 위치 차이 구하기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			siblings[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
		}

		Arrays.sort(siblings);

		// 각 차이의 최대공약수 구하기 - 유클리드 호제법
		int a = siblings[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			int remainder = -1;
			int b = siblings[i];

			while (remainder != 0) {
				remainder = a % b;
				a = b;
				b = (remainder == 0)? b : remainder;
			}

			a = b;
		}

		System.out.println(a);
	}

}
