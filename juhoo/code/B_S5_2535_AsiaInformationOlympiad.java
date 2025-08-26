package source_code;

import java.io.*;
import java.util.*;

// 성적 순 세 명 금, 은, 동
// 동점자 없음, 나라별 메달 수 최대 두 개

public class B_S5_2535_AsiaInformationOlympiad {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] grades = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			grades[i][0] = Integer.parseInt(st.nextToken());
			grades[i][1] = Integer.parseInt(st.nextToken());
			grades[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(grades, (a1, a2) -> {
			return a2[2] - a1[2];
		});

		int[] countryMedalCnt = new int[N];
		StringBuilder sb = new StringBuilder();
		int m = 0;

		for (int i = 0; i < N; i++) {
			if (m == 3) {
				break;
			}

			int country = grades[i][0];

			if (countryMedalCnt[country] == 2) {
				continue;
			}

			int student = grades[i][1];

			countryMedalCnt[country]++;
			sb.append(country).append(" ").append(student).append("\n");
			m++;
		}

		System.out.println(sb);

	}

}
