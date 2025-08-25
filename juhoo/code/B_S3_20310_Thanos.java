package source_code;

import java.io.*;
import java.util.*;

public class B_S3_20310_Thanos {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();

		List<Character> list = new ArrayList<>();
		for (char c : S) {
			list.add(c);
		}

		int zeroCnt = 0, oneCnt = 0;

		// 각 개수 세기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == '0') {
				zeroCnt++;
			} else {
				oneCnt++;
			}
		}

		int currentZeroCnt = 0, currentOneCnt = 0;
		int i = 0;

		if (oneCnt != 0) {
			while (i < list.size()) {
				if (list.get(i) == '1' && currentOneCnt < oneCnt / 2) {
					list.remove(i);
					currentOneCnt++;
				} else {
					i++;
				}
			}
		}

		i = list.size() - 1;

		if (zeroCnt != 0) {
			while (i >= 0) {
				if (list.get(i) == '0' && currentZeroCnt < zeroCnt / 2) {
					list.remove(i);
					currentZeroCnt++;
				}

				i--;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < list.size(); j++) {
			sb.append(list.get(j));
		}

		System.out.println(sb);
	}
}
