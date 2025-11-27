package source_code;

import java.io.*;
import java.util.*;

public class B_S5_CheckerOfGroupWord {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean isGroup = true;

			// 그룹 문자열인지 확인
			List<Character> usedChar = new ArrayList<>();
			int idx = 0;

			while (idx < str.length()) {
				char s = str.charAt(idx);
				idx++;

				while (idx < str.length() && str.charAt(idx) == s) {
					idx++;
				}

				if (!usedChar.contains(s)) {
					usedChar.add(s);
				} else {
					isGroup = false;
					break;
				}
			}

			if (isGroup == true) {
				result++;
			}
		}

		System.out.println(result);

	}

}
