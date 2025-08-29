package source_code;

import java.io.*;
import java.util.*;

public class B_S4_10825_KoreanEnglishMath {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<String, int[]> grades = new LinkedHashMap<>();

		// 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int[] grade = new int[3];

			int j = 0;
			while (st.hasMoreTokens()) {
				grade[j] = Integer.parseInt(st.nextToken());
				j++;
			}

			grades.put(name, grade);
		}

		// sort
		List<Map.Entry<String, int[]>> entryList = new ArrayList<>(grades.entrySet());
		entryList.sort((e1, e2) -> {
			if (e1.getValue()[0] != e2.getValue()[0]) {
				return e2.getValue()[0] - e1.getValue()[0];
			} else if (e1.getValue()[1] != e2.getValue()[1]) {
				return e1.getValue()[1] - e2.getValue()[1];
			} else if (e1.getValue()[2] != e2.getValue()[2]) {
				return e2.getValue()[2] - e1.getValue()[2];
			} else {
				return e1.getKey().compareTo(e2.getKey());
			}
		});

		StringBuilder sb = new StringBuilder();
		int i = 0;

		for (Map.Entry<String, int[]> e : entryList) {
			sb.append(e.getKey());

			if (i < N) {
				sb.append("\n");
			}
			i++;
		}

		System.out.println(sb);
	}

}
