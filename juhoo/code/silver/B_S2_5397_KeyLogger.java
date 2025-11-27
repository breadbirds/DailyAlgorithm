package source_code;

import java.io.*;
import java.util.*;

// 알파벳 대소문자, 숫자, 백스페이스, 화살표

public class B_S2_5397_KeyLogger {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < testCase; tc++) {
			char[] input = br.readLine().toCharArray();
			int cursorIndex = 0;
			LinkedList<Character> result = new LinkedList<>();

			for (char c : input) {
				switch (c) {
				case '<':
					cursorIndex = (cursorIndex == 0) ? 0 : cursorIndex - 1;
					break;

				case '>':
					if (result.size() == 0) {
						cursorIndex = 0;
					} else {
						cursorIndex = (cursorIndex >= result.size() - 1) ? result.size() : cursorIndex + 1;
					}
					break;
				case '-':
					if (cursorIndex == 0) {
						break;
					}

					result.remove(cursorIndex - 1);
					cursorIndex--;
					break;
				default:
					if (cursorIndex > result.size()) {
						result.add(c);
					} else {
						result.add(cursorIndex, c);
					}
					cursorIndex++;
					break;

				}
			}

			for (char c : result) {
				sb.append(c);
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

}
