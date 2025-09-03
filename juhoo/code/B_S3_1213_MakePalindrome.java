package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1213_MakePalindrome {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		char[] output = new char[input.length];

		Map<Character, Integer> cntMap = new TreeMap<>();
		for (char c : input) {
			cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
		}
		
		System.out.println(cntMap);
		
		int oddCnt = 0;
		for (int i : cntMap.values()) {
			oddCnt = (i % 2 == 0) ? oddCnt : oddCnt + 1;
		}

		if ((input.length % 2 == 0 && oddCnt > 0) || (input.length % 2 == 1 && oddCnt > 1)) {
			sb.append("I'm Sorry Hansoo");
		} else {
			int i = 0;

			for (char c : cntMap.keySet()) {
				int cnt = cntMap.get(c);

				if (cnt > 1) {
					while (cnt > 0) {
						output[i] = c;
						output[output.length - i - 1] = c;
						cnt -= 2;
						i++;

						if (cnt == 1) {
							output[output.length / 2] = c;
							cnt -= 1;
						}
					}

				} else {
					output[output.length / 2] = c;
				}
			}

			for (char c : output) {
				sb.append(c);
			}
		}

		System.out.println(sb);
	}
}
