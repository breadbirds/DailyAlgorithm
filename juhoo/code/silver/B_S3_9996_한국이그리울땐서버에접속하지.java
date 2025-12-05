package source_code;

import java.io.*;
import java.util.*;

public class B_S3_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] pattern = br.readLine().split("\\*");

		for (int tc = 0; tc < testCase; tc++) {
			boolean isDA = true;
			char[] str = br.readLine().toCharArray();

			if (str.length < pattern[0].length() + pattern[1].length()) {
				sb.append("NE").append("\n");
				continue;
			}

			for (int i = 0; i < pattern[0].length(); i++) {
				if (pattern[0].charAt(i) != str[i]) {
					isDA = false;
					break;
				}
			}

			int strIdx = str.length - 1;
			for (int i = pattern[1].length() - 1; i >= 0; i--) {
				if (pattern[1].charAt(i) != str[strIdx]) {
					isDA = false;
					break;
				}

				strIdx--;
			}

			if (isDA == true) {
				sb.append("DA");
			} else {
				sb.append("NE");
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

}
