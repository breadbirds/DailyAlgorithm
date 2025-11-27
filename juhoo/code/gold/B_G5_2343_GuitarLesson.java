package source_code;

import java.io.*;
import java.util.*;

// 순서 변경 x
// 구하는 것: 가능한 블루레이의 크기 중 최소
// 이진탐색

public class B_G5_2343_GuitarLesson {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 강의 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이 개수
		int[] time = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int min = 0;

		for (int n : time) {
			max += n;
			if (min < n) {
				min = n;
			}
		}

		while (min < max) {
			int mid = (max + min) / 2;
			int groupCnt = 1; // 블루레이 개수
			int sum = 0; // 계산 값 저장할 변수

			for (int i = 0; i < N; i++) {
				if (sum + time[i] <= mid) {
					sum += time[i];
				} else {
					groupCnt++;
					sum = time[i];
				}
			}

			System.out.println(min + " " + max + " " + mid + " " + groupCnt + " " + sum);

			if (groupCnt > M) {
				min = mid + 1;
			} else {
				max = mid;
			}

		}

		System.out.println(min);
	}
}
