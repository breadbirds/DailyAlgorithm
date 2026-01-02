package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5597_20250619 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[31]; // 원래 반 학생 30명

		// 일단 반 학생 배열에 줄세우기
		for (int i = 1; i <= 30; i++) {
			arr[i] = i;
		}
		// arr 배열을 돌면서 입력받은 값이랑 동일하면 0만들기
		// 근데 입력받을건 28개 있음
		int cnt = 1;
		while (cnt <= 28) {

			int a = Integer.parseInt(br.readLine());

			for (int i = 1; i <= 30; i++) {
				if (arr[i] == a) {
					arr[i] = 0;
					cnt++;
				}
			}

		}

		for (int i = 1; i <= 30; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}

		}

	}

}
