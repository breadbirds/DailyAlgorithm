package source_code;

import java.io.*;
import java.util.*;

// 서로 다른 L개의 알파벳 소문자로 구성
// 최소 한 개의 모음 + 두 개의 자음
// 오름차순 정렬

public class B_G5_1759_makePassword {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] addedString = new String[L];
		StringBuilder sb = new StringBuilder();

		String[] letters = new String[C];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken();
		}

		Arrays.sort(letters); // 미리 오름차순 정렬
		Arrays.fill(addedString, "");

		dfs(letters, L, 0, addedString, sb, 0);

		System.out.println(sb);
	}

	private static void dfs(String[] letters, int l, int depth, String[] addedString, StringBuilder sb, int start) {
		if (depth == l) {
			// 최소 요건 만족 확인
			int consonantCnt = 0; // 자음
			int vowelCnt = 0; // 모음
			String[] vowel = { "a", "e", "i", "o", "u" };

			for (String s : addedString) {
				if (Arrays.stream(vowel).anyMatch(s::contains)) {
					vowelCnt++;
				} else {
					consonantCnt++;
				}
			}

			if (vowelCnt >= 1 && consonantCnt >= 2) {
				for (int i = 0; i < l; i++) {
					sb.append(addedString[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < letters.length; i++) {
			addedString[depth] = letters[i];

			dfs(letters, l, depth + 1, addedString, sb, i + 1);
		}
	}

}
