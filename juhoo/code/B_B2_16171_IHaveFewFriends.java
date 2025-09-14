package source_code;

import java.io.*;
import java.util.*;

public class B_B2_16171_IHaveFewFriends {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String findWord = br.readLine();
		boolean result = true;

		// 소문자로 통일
		input = input.toLowerCase();
		findWord = findWord.toLowerCase();

		// 숫자 제거
		int i = 0;
		while (i < input.length()) {
			char c = input.charAt(i);

			if (Character.isDigit(c)) {
				input = input.replace(String.valueOf(c), "");
			} else {
				i++;
			}
		}

		// input에 찾는 문자열이 있는지 확인
		result = input.contains(findWord);

		if (result == true) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
