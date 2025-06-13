package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 공집합 S
// add x: x를 추가 
// remove x: x 제거
// check x: x가 있으면 1, 없으면 0
// toggle x: x가 있으면 제거, 없으면 추가
// all: {1,2,..,20}으로 바꿈
// empty: 공집합으로 바꿈

// 입력: 수행할 연산 수 / 연산들(string, int)
// 출력: check 연산 실행 시 결과 출력(1 or 0)

public class B_S5_setManager {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int calNum = Integer.parseInt(br.readLine());

		Set<Integer> result = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < calNum; i++) {
			// List<Character> nextList = new ArrayList<>();
			String nextLine = br.readLine();
			String[] parts = nextLine.split(" ");

			String cal = parts[0];
			int num = 0;

			if (!parts[0].equals("empty") && !parts[0].equals("all")) {
				num = Integer.valueOf(nextLine.split(" ")[1]);
			}

			calculation(cal, num, result, sb);

		}

		System.out.println(sb);

	}

	private static void calculation(String cal, int num, Set<Integer> result, StringBuilder sb) {
		if (cal.equals("add")) { // 1번: add
			result.add(num);

		} else if (cal.equals("remove")) { // 2번: remove
			result.remove(num);

		} else if (cal.equals("check")) { // 3번: check
			if (result.contains(num)) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}

		} else if (cal.equals("toggle")) { // 4번: toggle
			if (result.contains(num)) {
				result.remove(num);
			} else {
				result.add(num);
			}

		} else if (cal.equals("all")) { // 5번: all
			result.clear();
			for (int i = 0; i < 20; i++) {
				result.add(i + 1);
			}

		} else { // 6번: empty
			result.clear();
		}
	}
}
