package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1541_lostParentheses {
	static StringBuilder str;
	static char nextSymbol;
	static String numSb;
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringBuilder();
		str.append(br.readLine());

		int result = 0;
		idx = 0;

		while (idx < str.length()) {
			numSb = "";
			nextSymbol = ' ';

			// 숫자와 기호 추출
			getNumberAndSymbol();

			// prev 연산이 (-)라면 뒤에 전부 더해서 빼기
			if (nextSymbol == '-') {
				result += Integer.parseInt(numSb);

				int cal = 0;
				while (idx < str.length()) {
					numSb = "";
					getNumberAndSymbol();
					cal += Integer.parseInt(numSb);
				}
				result -= cal;
			} else {
				result += Integer.parseInt(numSb);
			}

		}

		System.out.println(result);
	}

	private static void getNumberAndSymbol() {
		char c = str.charAt(idx);

		while (idx < str.length()) {
			c = str.charAt(idx);
			if (c == '-' || c == '+') {
				nextSymbol = c;
				idx++;
				break;
			}
			numSb += c;
			idx++;
		}

	}

}
